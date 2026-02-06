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
    <link rel="stylesheet" href="css/listtime.css">
</head>
<body>
    <div class="container" style="max-width: 900px;"> <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
            <h1 style="margin-bottom: 0; border: none;">Times Cadastrados</h1>
            <a href="cadastrarTime.jsp" class="btn btn-primary" style="width: auto; margin: 0;">+ Novo Time</a>
        </div>
        
  
            <p style="color: green; background: #e8f5e9; padding: 10px; border-radius: 5px; margin-bottom: 15px;">
 
            </p>


        <table>
            <thead>
                <tr>
                    <th style="width: 50px;">ID</th>
                    <th>Nome</th>
                    <th>Técnico (ID)</th>
                    <th style="width: 280px;">Ações</th> </tr>
            </thead>
            <tbody>

                <tr>
                    <td></td>
                    <td><strong></strong></td>
                    <td></td>
                    
                    <td class="actions">
                        <a href="jogadores.jsp?idTime=<%= /* insira aqui a variável do ID */ 1 %>" class="btn btn-view-players" title="Ver Elenco">
                            👟 Jogadores
                        </a>

                        <a href="editar.jsp?id=" class="btn btn-edit">
                            ✏️ Editar
                        </a>

                        <a href="excluir.jsp?id=" class="btn btn-delete" onclick="return confirm('Tem certeza que deseja apagar o time ?');">
                            🗑️
                        </a>
                    </td>
                </tr>

                    <tr><td colspan="4">Erro de conexão com o banco! Verifique o arquivo includes/conexao.jsp</td></tr>
  
            </tbody>
        </table>

        <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
    </div>
</body>
</html>