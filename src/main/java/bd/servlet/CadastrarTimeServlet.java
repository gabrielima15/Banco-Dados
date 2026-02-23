package bd.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import bd.dao.TimeFutebolDAO;
import bd.model.TimeFutebol;

@WebServlet(name = "CadastrarTimeServlet", urlPatterns = {"/CadastrarTimeServlet"})
public class CadastrarTimeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        request.setCharacterEncoding("UTF-8");

        try {
            // 1. Recupera os dados do formulário
            String nomeTime = request.getParameter("nome");
            String nomeCidade = request.getParameter("cidade");
            String nomeTecnico = request.getParameter("tecnico");
            String escudo = request.getParameter("escudo");
            int idCampeonato = Integer.parseInt(request.getParameter("idCampeonato"));

            // 2. Prepara o objeto de modelo
            TimeFutebol time = new TimeFutebol();
            time.setNome(nomeTime);
            time.setCaminhoEscudo(escudo);
            // Os nomes de cidade e técnico serão tratados dentro do DAO
            time.setNomeCidade(nomeCidade);
            time.setNomeTecnico(nomeTecnico);

            // 3. Chama o DAO para realizar o salvamento complexo
            TimeFutebolDAO dao = new TimeFutebolDAO();
            dao.salvarCompletoComCampeonato(time, idCampeonato);

            // 4. Redireciona para a lista de times após o sucesso
            response.sendRedirect("listarTimes.jsp");

        } catch (Exception e) {
            // Em caso de erro, volta para o index com a mensagem
            response.sendRedirect("index.jsp?erro=" + e.getMessage());
        }
    }
}