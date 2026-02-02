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
        <h2>Cadastro</h2>
        <form action="editar" method="post">

            <input type="hidden" name="id" value="<%= aluno!=null?aluno.getId():"" %>">

            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" value="<%= aluno.getNome() %>">
            </div>

            <div class="form-group">
                <label for="matricula">Matrícula:</label>
                <input type="text" id="matricula" name="matricula" value="<%= aluno.getMatricula() %>">
            </div>

            <div class="form-group">
                <label for="dataNascimento">Data de Nascimento</label>
                <input type="date" id="dataNascimento" name="dataNascimento" value="<%= aluno.getDataNascimento() %>">
            </div>

            <div class="form-group">
                <label>Possui necessidade específica?</label>
                <div class="radio-group">
                    <label><input type="radio" name="possuiNecessidadeEspecifica" value="true" <%= aluno.getPossuiNecessidadeEspecifica() == true ? "checked" : "" %>>
                        SIM
                    </label>
                    <label><input type="radio" name="possuiNecessidadeEspecifica" value="false" <%= aluno.getPossuiNecessidadeEspecifica() == false ? "checked" : "" %>>
                        NÃO
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label for="descricaoNecessidadeEspecifica">Descrição da necessidade específica:</label>
                <textarea id="descricaoNecessidadeEspecifica" name="descricaoNecessidadeEspecifica" rows="4" 
                        cols="50">
                        <%= aluno.getDescricaoNecessidadeEspecifica() %>
                </textarea>
            </div>

            <div class="form-group">
                <label for="estado">Curso:</label>
                <select id="curso" name="curso">
                    <option value="0">Selecione</option>
                    <% for(Curso curso:(List<Curso>)request.getAttribute("cursos")){ %>
                        <option value="<%=curso.getId()%>" <%= curso.getId() == aluno.getIdCurso() ? "selected" : "" %> >
                            <%=curso.getSigla()%> - <%=curso.getNome()%>
                        </option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <input type="submit" value="Enviar">
               
                <a href="/app-web">
                    <input type="button" value="Cancelar">
                </a>
            </div>

        </form>
    </div>

</body>
</html>