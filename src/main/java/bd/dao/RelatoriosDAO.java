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
import java.util.*;
import bd.util.ConnectionFactory;
import bd.model.RelatorioDTO;

public class RelatoriosDAO {
    // 1. INNER JOIN (3 tabelas + WHERE) - Atacantes e suas cidades
    public List<RelatorioDTO> consulta1() throws Exception {
        List<RelatorioDTO> lista = new ArrayList<>();
        String sql = "SELECT j.nome, j.posicao, t.nome as time, c.nome as cidade " +
                     "FROM jogador j " +
                     "INNER JOIN Time_futebol t ON j.id_time = t.id_time " +
                     "INNER JOIN cidade c ON t.id_cidade = c.id_cidade " +
                     "WHERE j.posicao = 'Atacante'";
        try (Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                RelatorioDTO d = new RelatorioDTO();
                d.coluna1 = rs.getString("nome"); d.coluna2 = rs.getString("posicao");
                d.coluna3 = rs.getString("time"); d.coluna4 = rs.getString("cidade");
                lista.add(d);
            }
        }
        return lista;
    }

    // 2. INNER JOIN (3 tabelas + WHERE) - Times em um campeonato específico
   public List<RelatorioDTO> consulta2() throws Exception {
    List<RelatorioDTO> lista = new ArrayList<>();
    // SQL que utiliza a tabela associativa conforme o seu script.sql
    String sql = "SELECT t.nome AS time, tec.nome AS tecnico, c.nome AS campeonato " +
                 "FROM Time_futebol t " +
                 "INNER JOIN tecnico tec ON t.id_tecnico = tec.id_tecnico " +
                 "INNER JOIN time_campeonato tc ON t.id_time = tc.id_time " +
                 "INNER JOIN campeonato c ON tc.id_campeonato = c.id_campeonato " +
                 "ORDER BY c.nome, t.nome";

    try (Connection c = ConnectionFactory.getConnection();
         PreparedStatement ps = c.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            RelatorioDTO dto = new RelatorioDTO();
            dto.coluna1 = rs.getString("time");
            dto.coluna2 = rs.getString("tecnico");
            dto.coluna3 = rs.getString("campeonato");
            lista.add(dto);
        }
    }
    return lista;
}

    // 3. GROUP BY + ORDER BY - Total de jogadores por time
    public List<RelatorioDTO> consulta3() throws Exception {
        List<RelatorioDTO> lista = new ArrayList<>();
        String sql = "SELECT t.nome, COUNT(j.id_jogador) as total " +
                     "FROM Time_futebol t INNER JOIN jogador j ON t.id_time = j.id_time " +
                     "GROUP BY t.nome ORDER BY total DESC";
        try (Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                RelatorioDTO d = new RelatorioDTO();
                d.coluna1 = rs.getString("nome"); d.total = rs.getInt("total");
                lista.add(d);
            }
        }
        return lista;
    }

    // 4. GROUP BY + ORDER BY - Total de times por cidade
    public List<RelatorioDTO> consulta4() throws Exception {
        List<RelatorioDTO> lista = new ArrayList<>();
        String sql = "SELECT c.nome, COUNT(t.id_time) as total " +
                     "FROM cidade c INNER JOIN Time_futebol t ON c.id_cidade = t.id_cidade " +
                     "GROUP BY c.nome ORDER BY c.nome ASC";
        try (Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                RelatorioDTO d = new RelatorioDTO();
                d.coluna1 = rs.getString("nome"); d.total = rs.getInt("total");
                lista.add(d);
            }
        }
        return lista;
    }

    // 5. LEFT JOIN - Todos os times e seus jogadores (mesmo sem jogadores)
    public List<RelatorioDTO> consulta5() throws Exception {
        List<RelatorioDTO> lista = new ArrayList<>();
        String sql = "SELECT t.nome as time, j.nome as jogador " +
                     "FROM Time_futebol t LEFT JOIN jogador j ON t.id_time = j.id_time";
        try (Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                RelatorioDTO d = new RelatorioDTO();
                d.coluna1 = rs.getString("time"); d.coluna2 = rs.getString("jogador");
                lista.add(d);
            }
        }
        return lista;
    }

    // 6. SUBCONSULTA - Jogadores do time que tem o ID mais alto (exemplo técnico)
    public List<RelatorioDTO> consulta6() throws Exception {
        List<RelatorioDTO> lista = new ArrayList<>();
        String sql = "SELECT nome, posicao FROM jogador WHERE id_time = (SELECT MAX(id_time) FROM Time_futebol)";
        try (Connection c = ConnectionFactory.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                RelatorioDTO d = new RelatorioDTO();
                d.coluna1 = rs.getString("nome"); d.coluna2 = rs.getString("posicao");
                lista.add(d);
            }
        }
        return lista;
    }
}