<%-- 
    Document   : editar.jsp
    Created on : Feb 1, 2026, 6:31:35 PM
    Author     : janailson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Editar Time #</h1>
        
        
            <p style="color: var(--danger-color); font-weight: bold;"></p> 
       
        
        <form method="post" action="editar.jsp?id=>
            <div class="form-group">
                <label>Nome do Time:</label>
                <input type="text" name="nome" value="" required>
            </div>
            
            <div class="form-group">
                <label>ID do Técnico:</label>
                <input type="number" name="id_tecnico" value="" required>
            </div>

            <button type="submit" class="btn btn-primary">Salvar Alterações</button>
        </form>
        
        <a href="listar.jsp" class="btn btn-secondary">Cancelar</a>
    </div>
</body>
</html>
