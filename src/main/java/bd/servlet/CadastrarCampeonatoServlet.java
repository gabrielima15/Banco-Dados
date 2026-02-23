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
import bd.dao.CampeonatoDAO;
import bd.model.Campeonato;

@WebServlet(name = "CadastrarCampeonatoServlet", urlPatterns = {"/CadastrarCampeonatoServlet"})
public class CadastrarCampeonatoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        try {
            String nome = request.getParameter("nomeCampeonato");
            
            Campeonato c = new Campeonato();
            c.setNome(nome);
            
            CampeonatoDAO dao = new CampeonatoDAO();
            dao.salvar(c);

            // Redireciona de volta para a tela de cadastro de TIME
            response.sendRedirect("cadastrarTime.jsp");

        } catch (Exception e) {
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}