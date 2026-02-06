<%-- 
    Document   : list.jsp
    Created on : Feb 1, 2026, 6:30:18 PM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Times</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container" style="max-width: 800px;">
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
            <h1 style="margin-bottom: 0; border: none;">Times Cadastrados</h1>
            <a href="cadastrar.jsp" class="btn btn-primary" style="width: auto; margin: 0;">+ Novo</a>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Cidade</th>
                    <th>Campeonato</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td>"id"</td>
                    <td>"nome"</td>
                    <td>"nome_cidade"</td>
                    <td>"nome_camp"</td>
                    <td class="actions">
                        <a href="editar.jsp?id= " class="btn btn-edit">Editar</a>
                        <a href="excluir.jsp?id=" class="btn btn-delete" onclick="return confirm('Deseja realmente excluir o time?');">Excluir</a>
                    </td>
                </tr>

            </tbody>
        </table>

        <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
    </div>
</body>
</html>
