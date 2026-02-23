<%-- 
    Document   : relatorioTotalJogadores
    Created on : Feb 22, 2026, 10:50:05 AM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.RelatorioDTO, bd.dao.RelatoriosDAO" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Total de Jogadores</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container container-md">
        <h1>Jogadores por Equipe</h1>
        <table>
            <thead>
                <tr>
                    <th>Nome do Time</th><th class="text-center">Total</th>
                </tr>
            </thead>
            <tbody>
                <% try {
                    RelatoriosDAO dao = new RelatoriosDAO();
                    List<RelatorioDTO> lista = dao.consulta3();
                    for(RelatorioDTO r : lista) { %>
                    <tr>
                        <td><strong><%= r.coluna1 %></strong></td>
                        <td class="text-center"><%= r.total %></td>
                    </tr>
                <% } } catch(Exception e) { %>
                    <tr><td colspan="2" class="text-danger text-center">Erro: <%= e.getMessage() %></td></tr>
                <% } %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>