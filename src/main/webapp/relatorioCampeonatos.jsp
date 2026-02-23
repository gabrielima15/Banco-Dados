<%-- 
    Document   : relatorioCampeonatos
    Created on : Feb 22, 2026, 10:49:36 AM
    Author     : janailson
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.RelatorioDTO, bd.dao.RelatoriosDAO" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Relatório de Campeonatos</title>
    <%-- Uso do contextPath para carregar o CSS corretamente --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container container-lg">
        <h1>Times em Campeonatos</h1>
        <table class="table-custom">
            <thead>
                <tr>
                    <th>Time</th>
                    <th>Técnico</th>
                    <th>Campeonato</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    try {
                        RelatoriosDAO dao = new RelatoriosDAO();
                        List<RelatorioDTO> lista = dao.consulta2();
                        if (lista.isEmpty()) {
                %>
                    <tr><td colspan="3" style="text-align: center;">Nenhum time vinculado a campeonato encontrado.</td></tr>
                <% 
                        } else {
                            for(RelatorioDTO r : lista) { 
                %>
                    <tr>
                        <td><strong><%= r.coluna1 %></strong></td>
                        <td><%= r.coluna2 %></td>
                        <td><%= r.coluna3 %></td>
                    </tr>
                <% 
                            } 
                        } 
                    } catch(Exception e) { 
                %>
                    <tr><td colspan="3" style="color: red; text-align: center;">Erro: <%= e.getMessage() %></td></tr>
                <% } %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>