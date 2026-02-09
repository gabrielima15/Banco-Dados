package bd.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bd.dao.TimeFutebolDAO;


@WebServlet(name = "CadastrarTimeServlet", urlPatterns = {"/CadastrarTimeServlet"})
public class CadastrarTimeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String nomeTime = request.getParameter("nome");
        String nomeCidade = request.getParameter("cidade");
        String nomeTecnico = request.getParameter("tecnico");

        String mensagem = "";
        String tipoMensagem = "";

        try {
            if (nomeTime != null && !nomeTime.isEmpty() && 
                nomeCidade != null && !nomeCidade.isEmpty() && 
                nomeTecnico != null && !nomeTecnico.isEmpty()) {

                TimeFutebolDAO dao = new TimeFutebolDAO();
                dao.salvarCompleto(nomeTime, nomeCidade, nomeTecnico);

                mensagem = "Time cadastrado com sucesso!";
                tipoMensagem = "sucesso";
            } else {
                mensagem = "Preencha todos os campos!";
                tipoMensagem = "erro";
            }

        } catch (Exception e) {
            mensagem = "Erro ao cadastrar: " + e.getMessage();
            tipoMensagem = "erro";
        }

        request.setAttribute("mensagem", mensagem);
        request.setAttribute("tipoMensagem", tipoMensagem);
        
        request.getRequestDispatcher("cadastrarTime.jsp").forward(request, response);
    }
}