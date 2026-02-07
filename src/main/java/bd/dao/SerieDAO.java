package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import java.util.ArrayList;

import bd.model.Serie;
import bd.dto.SerieDTO;
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

    // public List<SerieDTO> listarDTO() throws Exception {
    //     List<SerieDTO> lista = new ArrayList<>();
    //     String sql = "SELECT s.id, t.nome AS nome_time, c.nome AS nome_campeonato " +
    //                  "FROM Serie s " +
    //                  "JOIN Time t ON s.id_time = t.id " +
    //                  "JOIN Campeonato c ON s.id_campeonato = c.id";

    //     try(Connection c = ConnectionFactory.getConnection(); 
    //         Statement st = c.createStatement()){
    //         ResultSet rs = st.executeQuery(sql);
    //         while (rs.next()) {
    //             lista.add(new SerieDTO(
    //                 rs.getInt("id"),
    //                 rs.getString("nome_time"),
    //                 rs.getString("nome_campeonato")
    //             ));
    //         }
    //     }
    //     return lista;
    // }

    public void atualizar(Serie serie) throws Exception {
        String sql = "UPDATE Serie SET id_time=?, id_campeonato=? WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)){

                ps.setObject(1, serie.getIdtime());
                ps.setObject(2, serie.getIdcampeonato());
                ps.setInt(3, serie.getId());
                ps.execute();
        }
    }
    
}
