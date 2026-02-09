package bd.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bd.dao.TimeFutebolDAO;

@WebServlet(name = "ExcluirTimeServlet", urlPatterns = {"/ExcluirTimeServlet"})
public class ExcluirTimeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            TimeFutebolDAO dao = new TimeFutebolDAO();
            dao.excluir(id);

        } catch (Exception e) {
            e.printStackTrace(); 
        }

        response.sendRedirect("listarTimes.jsp");
    }
}