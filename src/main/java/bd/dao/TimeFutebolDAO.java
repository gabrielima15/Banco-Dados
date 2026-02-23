package bd.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import bd.util.ConnectionFactory;
import bd.model.TimeFutebol;

public class TimeFutebolDAO {

    public void salvarCompletoComCampeonato(TimeFutebol time, int idCampeonato) throws Exception {
        Connection c = ConnectionFactory.getConnection();
        c.setAutoCommit(false); // Inicia transação para garantir que ou salva tudo ou nada

        try {
            // 1. Inserir Cidade e pegar ID
            String sqlCidade = "INSERT INTO cidade (nome) VALUES (?) RETURNING id_cidade";
            PreparedStatement psC = c.prepareStatement(sqlCidade);
            psC.setString(1, time.getNomeCidade());
            ResultSet rsC = psC.executeQuery();
            int idCidade = 0;
            if (rsC.next()) idCidade = rsC.getInt(1);

            // 2. Inserir Técnico e pegar ID
            String sqlTecnico = "INSERT INTO tecnico (nome) VALUES (?) RETURNING id_tecnico";
            PreparedStatement psTec = c.prepareStatement(sqlTecnico);
            psTec.setString(1, time.getNomeTecnico());
            ResultSet rsTec = psTec.executeQuery();
            int idTecnico = 0;
            if (rsTec.next()) idTecnico = rsTec.getInt(1);

            // 3. Inserir o Time e pegar ID
            String sqlTime = "INSERT INTO Time_futebol (nome, caminho_escudo, id_cidade, id_tecnico) VALUES (?, ?, ?, ?) RETURNING id_time";
            PreparedStatement psTime = c.prepareStatement(sqlTime);
            psTime.setString(1, time.getNome());
            psTime.setString(2, time.getCaminhoEscudo());
            psTime.setInt(3, idCidade);
            psTime.setInt(4, idTecnico);
            ResultSet rsT = psTime.executeQuery();
            int idTime = 0;
            if (rsT.next()) idTime = rsT.getInt(1);

            // 4. Inserir vínculo na tabela associativa
            String sqlVinculo = "INSERT INTO time_campeonato (id_time, id_campeonato) VALUES (?, ?)";
            PreparedStatement psV = c.prepareStatement(sqlVinculo);
            psV.setInt(1, idTime);
            psV.setInt(2, idCampeonato);
            psV.execute();

            c.commit(); 
        } catch (SQLException e) {
            c.rollback(); 
            throw e;
        } finally {
            c.close();
        }
    }


    public List<TimeFutebol> listar() throws Exception {
        List<TimeFutebol> lista = new ArrayList<>();
        String sql = "SELECT t.id_time, t.nome, t.caminho_escudo, c.nome AS nome_cidade, te.nome AS nome_tecnico " +
                     "FROM Time_futebol t " +
                     "INNER JOIN cidade c ON t.id_cidade = c.id_cidade " +
                     "INNER JOIN tecnico te ON t.id_tecnico = te.id_tecnico ORDER BY t.id_time";

        try(Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement()){
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                TimeFutebol time = new TimeFutebol();
                time.setId(rs.getInt("id_time"));
                time.setNome(rs.getString("nome"));
                time.setCaminhoEscudo(rs.getString("caminho_escudo")); 
                time.setNomeCidade(rs.getString("nome_cidade"));
                time.setNomeTecnico(rs.getString("nome_tecnico"));
                lista.add(time);         
            }
        }
        return lista;
    }

    public void excluir(int id) throws Exception {
        try (Connection c = ConnectionFactory.getConnection()) {
            c.setAutoCommit(false);
            try {
                // 1. Descobrir IDs de cidade e técnico antes de apagar o time
                int idCidade = 0, idTecnico = 0;
                String sqlBusca = "SELECT id_cidade, id_tecnico FROM Time_futebol WHERE id_time = ?";
                PreparedStatement psB = c.prepareStatement(sqlBusca);
                psB.setInt(1, id);
                ResultSet rs = psB.executeQuery();
                if(rs.next()){
                    idCidade = rs.getInt("id_cidade");
                    idTecnico = rs.getInt("id_tecnico");
                }

                // 2. Remover vínculos e o Time
                c.prepareStatement("DELETE FROM time_campeonato WHERE id_time = " + id).execute();
                c.prepareStatement("DELETE FROM jogador WHERE id_time = " + id).execute(); // Garante limpeza de jogadores
                c.prepareStatement("DELETE FROM Time_futebol WHERE id_time = " + id).execute();

                // 3. Limpar a cidade e o técnico (evita dados órfãos)
                c.prepareStatement("DELETE FROM cidade WHERE id_cidade = " + idCidade).execute();
                c.prepareStatement("DELETE FROM tecnico WHERE id_tecnico = " + idTecnico).execute();

                c.commit();
            } catch (SQLException e) {
                c.rollback();
                throw e;
            }
        }
    }

    public void atualizarCompleto(TimeFutebol time, int idCampeonato) throws Exception {
        Connection c = ConnectionFactory.getConnection();
        c.setAutoCommit(false); // Inicia transação

        try {
            // 1. Descobrir IDs atuais de cidade e técnico para atualizar seus nomes
            int idCidade = 0, idTecnico = 0;
            String sqlBusca = "SELECT id_cidade, id_tecnico FROM Time_futebol WHERE id_time = ?";
            try (PreparedStatement psB = c.prepareStatement(sqlBusca)) {
                psB.setInt(1, time.getId());
                ResultSet rs = psB.executeQuery();
                if (rs.next()) {
                    idCidade = rs.getInt("id_cidade");
                    idTecnico = rs.getInt("id_tecnico");
                }
            }

            // 2. Atualizar tabela 'cidade' e 'tecnico'
            String sqlC = "UPDATE cidade SET nome = ? WHERE id_cidade = ?";
            PreparedStatement psC = c.prepareStatement(sqlC);
            psC.setString(1, time.getNomeCidade());
            psC.setInt(2, idCidade);
            psC.executeUpdate();

            String sqlT = "UPDATE tecnico SET nome = ? WHERE id_tecnico = ?";
            PreparedStatement psT = c.prepareStatement(sqlT);
            psT.setString(1, time.getNomeTecnico());
            psT.setInt(2, idTecnico);
            psT.executeUpdate();

            // 3. Atualizar tabela 'Time_futebol'
            String sqlTime = "UPDATE Time_futebol SET nome = ?, caminho_escudo = ? WHERE id_time = ?";
            PreparedStatement psTime = c.prepareStatement(sqlTime);
            psTime.setString(1, time.getNome());
            psTime.setString(2, time.getCaminhoEscudo());
            psTime.setInt(3, time.getId());
            psTime.executeUpdate();

            // 4. ATUALIZAR VÍNCULO DO CAMPEONATO (Limpa antigo e insere novo)
            c.prepareStatement("DELETE FROM time_campeonato WHERE id_time = " + time.getId()).executeUpdate();

            String sqlVinculo = "INSERT INTO time_campeonato (id_time, id_campeonato) VALUES (?, ?)";
            PreparedStatement psV = c.prepareStatement(sqlVinculo);
            psV.setInt(1, time.getId());
            psV.setInt(2, idCampeonato);
            psV.executeUpdate();

            c.commit(); // Salva tudo
        } catch (SQLException e) {
            c.rollback(); // Se der erro, desfaz tudo
            throw e;
        } finally {
            c.close();
        }
    }
    
    

    public TimeFutebol buscar(int id) throws Exception {
        String sql = "SELECT t.id_time, t.nome, t.caminho_escudo, t.id_cidade, t.id_tecnico, " +
                     "c.nome AS nome_cidade, te.nome AS nome_tecnico " +
                     "FROM Time_futebol t " +
                     "INNER JOIN cidade c ON t.id_cidade = c.id_cidade " +
                     "INNER JOIN tecnico te ON t.id_tecnico = te.id_tecnico " +
                     "WHERE t.id_time = ?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                TimeFutebol time = new TimeFutebol();
                time.setId(rs.getInt("id_time"));
                time.setNome(rs.getString("nome"));
                time.setCaminhoEscudo(rs.getString("caminho_escudo"));
                time.setId_cidade(rs.getInt("id_cidade"));
                time.setIdtecnico(rs.getInt("id_tecnico"));
                time.setNomeCidade(rs.getString("nome_cidade"));
                time.setNomeTecnico(rs.getString("nome_tecnico"));
                
                return time;
            }
        }
        return null;
    }
    
    
}
    
