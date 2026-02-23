package bd.dao;


import bd.model.Campeonato;
import bd.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CampeonatoDAO {

    public List<Campeonato> listar() throws Exception {
        List<Campeonato> lista = new ArrayList<>();
        String sql = "SELECT * FROM campeonato";
        try(Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement()){
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new Campeonato(rs.getInt("id_campeonato"), rs.getString("nome")));
            }
        }
        return lista;
    }


    public Campeonato buscar(int id) throws Exception {
        String sql = "SELECT * FROM campeonato WHERE id_campeonato=?";
        try(Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Campeonato(rs.getInt("id_campeonato"), rs.getString("nome"));
            }
        }
        return null;
    }


    public void atualizar(Campeonato campeonato) throws Exception {
        String sql = "UPDATE campeonato SET nome=? WHERE id_campeonato=?";
        try(Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1, campeonato.getNome());
            ps.setInt(2, campeonato.getId()); 
            ps.execute();
        }
    }

    public void excluir(int id) throws Exception{
        String sql = "DELETE FROM campeonato WHERE id_campeonato=?";
        try(Connection c = ConnectionFactory.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        }
    }
    
    public void salvar(Campeonato campeonato) throws Exception {
        String sql = "INSERT INTO campeonato (nome) VALUES (?)";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, campeonato.getNome());
            ps.execute();
        }
    }
}