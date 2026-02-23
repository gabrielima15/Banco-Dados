/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd.dao;

/**
 *
 * @author janailson
 */

import java.sql.*;
import bd.util.ConnectionFactory;
import bd.model.Jogador;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {
    public void salvar(Jogador jogador) throws Exception {

        String sql = "INSERT INTO jogador (nome, n_camisa, posicao, caminho_foto, id_time) VALUES (?, ?, ?, ?, ?)";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getnCamisa());
            ps.setString(3, jogador.getPosicao()); // Agora como String
            ps.setString(4, jogador.getCaminhoFoto());
            ps.setInt(5, jogador.getIdTime());
            
            ps.execute();
        }
    }
    

    public List<Jogador> listarPorTime(int idTime) throws Exception {
        List<Jogador> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogador WHERE id_time = ? ORDER BY n_camisa";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, idTime);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Jogador(
                    rs.getInt("id_jogador"),
                    rs.getString("nome"),
                    rs.getInt("n_camisa"),
                    rs.getString("posicao"),
                    rs.getString("caminho_foto"),
                    rs.getInt("id_time")
                ));
            }
        }
        return lista;
    }

    public void atualizar(Jogador jogador) throws Exception {
        String sql = "UPDATE jogador SET nome=?, n_camisa=?, posicao=?, caminho_foto=?, id_time=? WHERE id_jogador=?";

        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, jogador.getNome());
            ps.setInt(2, jogador.getnCamisa());
            ps.setString(3, jogador.getPosicao());
            ps.setString(4, jogador.getCaminhoFoto());
            ps.setInt(5, jogador.getIdTime());
            ps.setInt(6, jogador.getId());

            ps.execute();
        }
    }
    
    
 
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM jogador WHERE id_jogador = ?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        }
    }
}