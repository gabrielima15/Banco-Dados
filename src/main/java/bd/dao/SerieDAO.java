package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import java.util.ArrayList;

import bd.model.Serie;
import bd.util.ConnectionFactory;

public class SerieDAO {

    public List<Serie> listar() throws Exception{
        List<Serie> lista = new ArrayList<>();

        String sql = "SELECT * FROM Serie";

        try(Connection c = ConnectionFactory.getConnection(); 
                Statement st = c.createStatement()){
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    lista.add(new Serie(
                        rs.getInt("id"),
                        rs.getObject("id_time",Integer.class),
                        rs.getObject("id_campeonato",Integer.class)
                    ));
                }
        }
        return lista;
    }

    public void atualizar(Serie serie) throws Exception {
        String sql = "UPDATE Serie SET id_time=?, id_campeonato=? WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)){

                ps.setObject(1, serie.getIdtime());
                ps.setObject(2, serie.getIdcampeonato());
                ps.execute();
        }
    }

    public void excluir(int id) throws Exception{
        String sql = "DELETE FROM Serie WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
                
                ps.setInt(1, id);
                ps.execute();
        }
    }
}
