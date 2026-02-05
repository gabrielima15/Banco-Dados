package bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import bd.util.ConnectionFactory;
import bd.model.Campeonato;

public class CampeonatoDAO {
    
    public void salvar(Campeonato campeonato) throws Exception {
        String sql = "INSERT INTO Campeonato(nome) "+"VALUES (?)";

        try(Connection c = ConnectionFactory.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setString(1, campeonato.getNome());
            ps.execute();
        }
    }

    // public List<Campeonato> listar() throws Exception{
    //     List<Campeonato> lista = new ArrayList<>();

    // }
}
