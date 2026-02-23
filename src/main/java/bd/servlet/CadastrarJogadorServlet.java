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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import bd.dao.JogadorDAO;
import bd.model.Jogador;
import jakarta.servlet.annotation.WebServlet; // Certifique-se de usar o pacote jakarta

@WebServlet(name = "CadastrarJogadorServlet", urlPatterns = {"/CadastrarJogadorServlet"})
public class CadastrarJogadorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        try {
            String nome = request.getParameter("nome");
            int camisa = Integer.parseInt(request.getParameter("camisa"));
            String posicao = request.getParameter("posicao");
            int idTime = Integer.parseInt(request.getParameter("idTime"));
            String foto = request.getParameter("foto");

            Jogador j = new Jogador(nome, camisa, posicao, foto, idTime);
            JogadorDAO dao = new JogadorDAO();
            dao.salvar(j);

            // Após salvar, volta para a lista de jogadores daquele time
            response.sendRedirect("jogadores.jsp?idTime=" + idTime);

        } catch (Exception e) {
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}