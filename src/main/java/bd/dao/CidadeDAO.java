package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import java.util.ArrayList;

import bd.model.Cidade;
import bd.util.ConnectionFactory;

public class CidadeDAO {
    
    public void salvar(Cidade cidade) throws Exception {
        String sql = "INSERT INTO Cidade(nome) "+"VALUES (?)";

        try(Connection c = ConnectionFactory.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setString(1, cidade.getNome());
            ps.execute();
        }
    }

    public List<Cidade> listar() throws Exception{
        List<Cidade> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cidade";

        try(Connection c = ConnectionFactory.getConnection(); 
                Statement st = c.createStatement()){
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    lista.add(new Cidade(
                        rs.getInt("id"),
                        rs.getString("nome")
                    ));
                }
        }
        return lista;
    }

    public Cidade buscar(int id) throws Exception {
        String sql = "SELECT * FROM Cidade WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if(rs.next()){
                    return new Cidade(
                    rs.getInt("id"), 
                    rs.getString("nome")
                   );
                }
        }
        return null;
    }

    public void atualizar(Cidade cidade) throws Exception {
        String sql = "UPDATE Cidade SET nome=? WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

                ps.setString(1, cidade.getNome());
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
