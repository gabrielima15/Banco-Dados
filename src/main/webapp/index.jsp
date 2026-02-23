<%-- 
    Document   : index.jsp
    Created on : Feb 1, 2026, 5:45:37 PM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Menu Principal - Gestão Esportiva</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>⚽ Gestão de Campeonato</h1>
        
        <div class="section-title">Cadastros (CRUD)</div>
        <div class="menu-buttons">
            <a href="Campeonato.jsp" class="btn btn-primary">🏆 Listar Campeonatos</a>
            <a href="listarTimes.jsp" class="btn btn-primary">👕 Gerenciar Times</a>
            <a href="cadastrarTime.jsp" class="btn btn-primary">➕ Cadastrar Novo Time</a>
            <a href="cadastrarJogador.jsp" class="btn btn-primary">➕ Novo Jogador</a>
        </div>

        <div class="separator"></div>

        <div class="section-title">Relatórios do Projeto (Parte 2)</div>
        <div class="menu-buttons" style="display: flex; flex-direction: column; gap: 8px;">
            <a href="relatorioAtacantes.jsp" class="btn btn-view">1. Atacantes e Cidades</a>
            <a href="relatorioCampeonatos.jsp" class="btn btn-view">2. Times em Campeonatos</a>
            <a href="relatorioTotalJogadores.jsp" class="btn btn-view">3. Total de Atletas por Time</a>
            <a href="relatorioTimesPorCidade.jsp" class="btn btn-view">4. Times por Cidade</a>
            <a href="relatorioGeralElencos.jsp" class="btn btn-view">5. Lista Geral (LEFT JOIN)</a>
            <a href="relatorioUltimoTime.jsp" class="btn btn-view">6. Último Time (Subconsulta)</a>
        </div>
    </div>
</body>
</html>