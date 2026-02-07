package bd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.util.ArrayList;

import bd.util.ConnectionFactory;
import bd.model.Tecnico;

public class TecnicoDAO {
    
    public void salvar(Tecnico tecnico) throws Exception {
        String sql = "INSERT INTO Tecnico(nome) "+"VALUES (?)";

        try(Connection c = ConnectionFactory.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setString(1, tecnico.getNome());
            ps.execute();
        }
    }

    public List<Tecnico> listar() throws Exception{
        List<Tecnico> lista = new ArrayList<>();

        String sql = "SELECT * FROM Tecnico";

        try(Connection c = ConnectionFactory.getConnection(); 
                Statement st = c.createStatement()){
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    lista.add(new Tecnico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getObject("idTime",Integer.class)));
                }
        }
        return lista;
    }

    public Tecnico buscar(int id) throws Exception {
        String sql = "SELECT * FROM Tecnico WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    return new Tecnico(
                    rs.getInt("id"), 
                    rs.getString("nome"),
                    rs.getObject("idTime",Integer.class));
                }
        }
        return null;
    }

    public void atualizar(Tecnico Tecnico) throws Exception {
        String sql = "UPDATE Tecnico SET nome=? WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

                ps.setString(1, Tecnico.getNome());
                ps.execute();
        }
    }

    public void excluir(int id) throws Exception{
        String sql = "DELETE FROM Canpeonato WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
                
                ps.setInt(1, id);
                ps.execute();
        }
    }
}
