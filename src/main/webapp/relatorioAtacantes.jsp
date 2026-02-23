<%-- 
    Document   : relatorioAtacantes
    Created on : Feb 22, 2026, 10:48:46 AM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.RelatorioDTO, bd.dao.RelatoriosDAO" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Relatório de Atacantes</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container container-lg">
        <h1>Localização de Atacantes</h1>
        <table>
            <thead>
                <tr>
                    <th>Jogador</th><th>Posição</th><th>Time</th><th>Cidade</th>
                </tr>
            </thead>
            <tbody>
                <% try {
                    RelatoriosDAO dao = new RelatoriosDAO();
                    List<RelatorioDTO> lista = dao.consulta1();
                    for(RelatorioDTO r : lista) { %>
                    <tr>
                        <td><strong><%= r.coluna1 %></strong></td>
                        <td><%= r.coluna2 %></td><td><%= r.coluna3 %></td><td><%= r.coluna4 %></td>
                    </tr>
                <% } } catch(Exception e) { %>
                    <tr><td colspan="4" class="text-danger text-center">Erro: <%= e.getMessage() %></td></tr>
                <% } %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>