package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.util.ArrayList;

import bd.util.ConnectionFactory;
import bd.dto.QuantidadeTimesCidadeDTO;
import bd.dto.TimeJogadorDTO;
import bd.model.TimeFutebol;

public class TimeFutebolDAO {
    
    public void salvar(TimeFutebol time) throws Exception{
        String sql = "INSERT INTO Time_futebol" + "(nome,cidade,id_tecnico)" + "VALUES (?,?,?)";

        try (Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, time.getNome());
            ps.setObject(2, time.getIdcidade());  
            ps.setObject(3, time.getIdtecnico());
            ps.execute();
            
        }
    }

    public List<TimeFutebol> listar() throws Exception{
        List<TimeFutebol> lista = new ArrayList<>();
        String sql = "SELECT * FROM time_futebol";

        try(Connection c = ConnectionFactory.getConnection();
            Statement st = c.createStatement()){
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new TimeFutebol(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getObject("idcidade",Integer.class),
                    rs.getObject("id_tecnico",Integer.class)
                ));            
            }
        }
        return lista;
    }

    public List<QuantidadeTimesCidadeDTO> quantidadeTimePorCidade() throws Exception{
        List<QuantidadeTimesCidadeDTO> lista = new ArrayList<>();

        String sql = "SELECT"+" c.nome AS cidade," + 
                        "COUNT(t.id_time) AS quantidade_times" +
                        "FROM cidade c" +
                        "INNER JOIN time_futebol t " +
                        "ON c.id_cidade = t.id_cidade" + 
                        "GROUP BY c.nome" +
                        "ORDER BY quantidade_times DESC;";

        try (Connection c = ConnectionFactory.getConnection();
            Statement st = c.createStatement()){

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new QuantidadeTimesCidadeDTO(
                    rs.getString("cidade"),
                    rs.getLong("quantidade")
                ));
            }
            
        } catch (Exception e) {
            throw new Exception("Erro ao consultar quantidade de times por cidade: " +
            e.getMessage()); 
        }
        return lista;
    }

    public List<TimeJogadorDTO> listarTimesJogador() throws Exception{
        List<TimeJogadorDTO> lista = new ArrayList<>();
        
        String sql = "SELECT t.nome AS time,j.nome AS jogador,j.n_camisa,j.posicao"+
                    "FROM time_futebol t LEFT JOIN jogador j ON t.id_time = j.id_time"+
                    "ORDER BY t.nome, j.nome";
        try (Connection c = ConnectionFactory.getConnection();
            Statement st = c.createStatement()){

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new TimeJogadorDTO(
                    rs.getString("time"),
                    rs.getString("jogador")
                ));
            }
            
        } catch (Exception e) {
            throw new Exception("Erro ao consultar times e jogadores: " + e.getMessage());
        }
        return lista;
    }

    public TimeFutebol buscar(int id) throws Exception{
        String sql = "SELECT * FROM time_futebol WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new TimeFutebol(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getObject("idcidade",Integer.class),
                    rs.getObject("id_tecnico",Integer.class)
                );
            }
        }
        return null;
    }

    public void atualizar(TimeFutebol time)throws Exception{
        String sql = "UPDATE time_futebol SET nome=?,cidade=?,id_tecnico=?, WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, time.getNome());
            ps.setObject(2, time.getIdcidade());
            ps.setObject(3, time.getIdtecnico());
            ps.setInt(4, time.getId());

            ps.execute();
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM time_futebol WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();
        }
    }
}
