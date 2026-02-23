/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd.servlet;

/**
 *
 * @author janailson
 */


import java.io.IOException;
import jakarta.servlet.http.*;
import bd.dao.JogadorDAO;
import bd.model.Jogador;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;

@WebServlet(name = "EditarJogadorServlet", urlPatterns = {"/EditarJogadorServlet"})
public class EditarJogadorServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Garante que caracteres especiais (acentos) funcionem corretamente
        request.setCharacterEncoding("UTF-8");

        try {
            // Recupera os campos do formulário do Modal
            int id = Integer.parseInt(request.getParameter("id"));
            int idTime = Integer.parseInt(request.getParameter("idTime"));
            String nome = request.getParameter("nome");
            int camisa = Integer.parseInt(request.getParameter("camisa"));
            String posicao = request.getParameter("posicao");
            String foto = request.getParameter("foto");

            // Cria o objeto Jogador com o ID para atualizar o registro existente
            Jogador jogador = new Jogador(id, nome, camisa, posicao, foto, idTime);
            
            // Chama o DAO para persistir as mudanças no PostgreSQL
            JogadorDAO dao = new JogadorDAO();
            dao.atualizar(jogador);

            // Redireciona de volta para o elenco do time específico
            response.sendRedirect("jogadores.jsp?idTime=" + idTime);

        } catch (Exception e) {
            // Em caso de erro, volta para o menu inicial com a mensagem
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}