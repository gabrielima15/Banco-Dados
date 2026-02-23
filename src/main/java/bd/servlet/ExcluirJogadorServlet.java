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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import bd.dao.JogadorDAO;

@WebServlet(name = "ExcluirJogadorServlet", urlPatterns = {"/ExcluirJogadorServlet"})
public class ExcluirJogadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int idTime = Integer.parseInt(request.getParameter("idTime"));

            JogadorDAO dao = new JogadorDAO();
            dao.excluir(id);

            response.sendRedirect("jogadores.jsp?idTime=" + idTime);

        } catch (Exception e) {
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}