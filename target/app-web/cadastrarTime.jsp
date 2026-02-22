<%-- 
    Document   : form.jsp
    Created on : Feb 1, 2026, 6:27:06 PM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Novo Time</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel ="stylesheet" href="css/cadastrostyle.css">
</head>
<body>
    <div class="container">
        <div class="container-cadastro"> <h1>Cadastrar Time</h1> </div>
        
            <p style=" font-weight: bold; margin-bottom: 15px;"></p> 
        
        
        <form method="post" action="cadastrar.jsp">
            <div class="form-group">
                <label>Nome do Time:</label>
                <input type="text" name="nome" required placeholder="Ex: Vasco da Gama">
            </div>
            
            <div class="form-group">
                <label>Data Fundação:</label>
                <input type="date" name="data_fundacao" required>
            </div>
            
            <div class="form-group">
                <label style="display: flex; align-items: center; cursor: pointer;">
                    <input type="checkbox" name="tem_estadio" value="true"> 
                    Possui Estádio Próprio?
                </label>
            </div>
            
            <div class="form-group">
                <label>Cidade:</label>
                <input type="text" name="cidade" required placeholder="Consulte a tabela Cidade">
            </div>
            
            <div class="form-group">
                <label>Campeonato:</label>
                <input type="text" name="Nome campeonato" required placeholder="Consulte a tabela Campeonato">
            </div>
            
            <div class="form-group">
                <label>Técnico:</label>
                <input type="text" name="tecnico" required placeholder="Consulte a tabela Técnico">
            </div>
            
            <div class="form-group">
                <label>Estádio (Opcional):</label>
                <input type="text" name="estadio" placeholder="Deixe vazio se não tiver">
            </div>

            <button type="submit" class="btn btn-primary">Salvar Time</button>
        </form>
        
        <a href="index.jsp" class="btn btn-secondary">Voltar para Lista</a>
    </div>
</body>
</html>