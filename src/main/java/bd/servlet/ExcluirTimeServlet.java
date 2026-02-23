package bd.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
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

            response.sendRedirect("listarTimes.jsp?sucesso=Time excluido");
        } catch (Exception e) {
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}