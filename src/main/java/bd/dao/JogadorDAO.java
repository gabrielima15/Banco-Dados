package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import java.util.ArrayList;

import bd.dto.JogadorTimeCidadeDTO;
import bd.model.Jogador;
import bd.util.ConnectionFactory;

public class JogadorDAO {
    
    public void salvar(Jogador jogador) throws Exception{
        String sql = "INSERT INTO Jogador " + "(nome,N_camisa,posicao,id_time) " + "VALUES (?,?,?,?)";

        try (Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getnCamisa());  
            ps.setString(3, jogador.getPosicao());
            ps.setObject(4,jogador.getIdTime());
            ps.execute();
            
        }
    }

    public List<JogadorTimeCidadeDTO> listaJogadorTimeCidadeDTOs() throws Exception{
        List<JogadorTimeCidadeDTO> lista = new ArrayList<>();    

            String sql = "SELECT  j.nome AS jogador, tf.nome AS time,c.nome AS cidade,"+
                "te.nome AS tecnico FROM jogador j INNER JOIN time_futebol tf "+
                "ON j.id_time = tf.id_time INNER JOIN cidade c ON tf.id_cidade = c.id_cidade"+
                "INNER JOIN tecnico te ON tf.id_tecnico = te.id_tecnico where j.posicao = ?";

                try (Connection c = ConnectionFactory.getConnection();
                    Statement st = c.createStatement()) {
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        lista.add(new JogadorTimeCidadeDTO(
                            rs.getString("nomeJogador"),
                            rs.getString("nomeTime"),
                            rs.getString("nomeCidade"),
                            rs.getInt("posicao")
                        ));
                        
                    }
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }
        return lista;
    }


    public List<Jogador> listar() throws Exception{
        List<Jogador> lista = new ArrayList<>();
        String sql = "SELECT * FROM Jogador";

        try(Connection c = ConnectionFactory.getConnection();
            Statement st = c.createStatement()){
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new Jogador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("N_camisa"),
                    rs.getString("posicao"),
                    rs.getObject("id_time",Integer.class)
                ));            
            }
        }
        return lista;
    }

    public Jogador buscar(int id) throws Exception{
        String sql = "SELECT * FROM Jogador WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Jogador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("N_camisa"),
                    rs.getString("posicao"),
                    rs.getObject("id_time",Integer.class)
                );
            }
        }
        return null;
    }

    public void atualizar(Jogador jogador)throws Exception{
        String sql = "UPDATE Jogador SET nome=?,N_camisa=?,id_time=? WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, jogador.getNome());
            ps.setInt(2,jogador.getnCamisa());
            ps.setString(3, jogador.getPosicao());
            ps.setObject(4, jogador.getIdTime());
            ps.execute();
        }
    }

    // public void atualizar(JogadorDTO jogador) throws Exception {
    //     String sql = "UPDATE Jogador SET nome=?, N_camisa=?, posicao=?, id_time=? WHERE id=?";

    //     try (Connection c = ConnectionFactory.getConnection();
    //             PreparedStatement ps = c.prepareStatement(sql)) {

    //         ps.setString(1, jogador.getNome());
    //         ps.setInt(2, jogador.getNumeroCamisa());
    //         ps.setInt(3, jogador.getPosicao());
    //         ps.setInt(4, jogador.getIdTime());
    //         ps.setInt(5, jogador.getId());

    //         ps.executeUpdate();
    //     }
    // }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Jogador WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();
        }
    }

}
