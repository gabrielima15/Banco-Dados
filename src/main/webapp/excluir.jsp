<%@ page import="br.edu.ifpb.bd.model.Aluno,java.util.*,br.edu.ifpb.bd.model.Curso" %>
<%
Aluno aluno = (Aluno) request.getAttribute("aluno");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Aluno</title>
    <link rel="stylesheet" href="css/estiloPaginaForm.css">
</head>
<body>
    <div class="container">
        <h2>Realmente deseja excluir?</h2>
        <form action="excluir" method="post">

            <input type="hidden" name="id" value="<%= aluno!=null?aluno.getId():"" %>">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <span><%= aluno.getNome() %></span>
            </div>

            <div class="form-group">
                <label for="matricula">Matrícula:</label>
                <span><%= aluno.getMatricula() %></span>
            </div>

            <div class="form-group">
                <label for="dataNascimento">Data de Nascimento</label>
                <span><%= aluno.getDataNascimento() %></span>
            </div>

            <div class="form-group">
                <input type="submit" value="Excluir">
               
                <a href="/app-web/listarAlunos">
                    <input type="button" value="Cancelar">
                </a>
            </div>

        </form>
    </div>

</body>
</html>