package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.naming.spi.DirStateFactory.Result;
import java.util.ArrayList;

import bd.model.Jogador;
import bd.util.ConnectionFactory;

public class JogadorDAO {
    
      public void salvar(Jogador jogador) throws Exception{
        String sql = "INSERT INTO Jogador " + "(nome,N_camisa,posicao,id_time) " + "VALUES (?,?,?,?)";

        try (Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getnCamisa());  
            ps.setInt(3, jogador.getPosicao());
            ps.setObject(4,jogador.getIdTime());
            ps.execute();
            
        }
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
                    rs.getInt("posicao"),
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
                    rs.getInt("posicao"),
                    rs.getObject("id_time",Integer.class)
                );
            }
        }
        return null;
    }

    public void atualizar(Jogador jogador)throws Exception{
        String sql = "UPDATE Jogador SET nome=?,N_camisa=?,id_time=?, WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, jogador.getNome());
            ps.setInt(2,jogador.getnCamisa());
            ps.setInt(3, jogador.getPosicao());
            ps.setObject(3, jogador.getIdTime());
            ps.execute();
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM Jogador WHERE id=?";

        try(Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();
        }
    }
}
