<%-- 
    Document   : relatorioUltimoTime
    Created on : Feb 22, 2026, 10:52:49 AM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.RelatorioDTO, bd.dao.RelatoriosDAO" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Destaque</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container container-md">
        <h1>Elenco do Time mais Recente</h1>
        <table>
            <thead>
                <tr>
                    <th>Nome do Jogador</th><th>Posição</th>
                </tr>
            </thead>
            <tbody>
                <% try {
                    RelatoriosDAO dao = new RelatoriosDAO();
                    List<RelatorioDTO> lista = dao.consulta6();
                    if(lista.isEmpty()){ %>
                        <tr><td colspan="2" class="text-center">Nenhum atleta cadastrado no último time.</td></tr>
                    <% } else {
                        for(RelatorioDTO r : lista) { %>
                        <tr>
                            <td><strong><%= r.coluna1 %></strong></td><td><%= r.coluna2 %></td>
                        </tr>
                <% } } } catch(Exception e) { %>
                    <tr><td colspan="2" class="text-danger text-center">Erro: <%= e.getMessage() %></td></tr>
                <% } %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-secondary">Voltar</a>
    </div>
</body>
</html>