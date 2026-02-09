package bd.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bd.dao.TimeFutebolDAO;
import bd.model.TimeFutebol;

@WebServlet(name = "EditarTimeServlet", urlPatterns = {"/EditarTimeServlet"})
public class EditarTimeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nomeTime = request.getParameter("nome");
            String nomeCidade = request.getParameter("cidade");
            String nomeTecnico = request.getParameter("tecnico");
            String urlEscudo = request.getParameter("escudo"); // Novo campo

            TimeFutebol time = new TimeFutebol();
            time.setId(id);
            time.setNome(nomeTime);
            time.setNomeCidade(nomeCidade);
            time.setNomeTecnico(nomeTecnico);
            time.setCaminhoEscudo(urlEscudo);

            TimeFutebolDAO dao = new TimeFutebolDAO();
            dao.atualizarCompleto(time);

            response.sendRedirect("listarTimes.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}