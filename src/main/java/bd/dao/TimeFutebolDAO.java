package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.util.ArrayList;

import bd.util.ConnectionFactory;
import bd.model.TimeFutebol;

public class TimeFutebolDAO {
    
    public void salvar(TimeFutebol time) throws Exception{
        String sql = "INSERT INTO Time_futebol" + "(nome,cidade,id_tecnico)" + "VALUES (?,?,?)";

        try (Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, time.getNome());
            ps.setString(2, time.getCidade());  
            ps.setObject(3, time.getIdTecnico());
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
                    rs.getString("cidade"),
                    rs.getObject("id_tecnico",Integer.class)
                ));            }
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
                    rs.getString("cidade"),
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
            ps.setString(2, time.getCidade());
            ps.setObject(3, time.getIdTecnico());
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
