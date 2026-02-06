<%-- 
    Document   : excluir.jsp
    Created on : Feb 1, 2026, 6:32:45 PM
    Author     : janailson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/style.css">
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Excluir Time</title>
    <link rel="stylesheet" href="css/estiloPaginaForm.css">
</head>
<body>
    <div class="container">
        <h2 style="color: red;">Realmente deseja excluir este time?</h2>
        <form action="excluirTime" method="post">

            <input type="hidden" name="id" value="">

            <div class="form-group">
                <label>Nome:</label>
                <span></span>
            </div>

            <div class="form-group">
                <label>Cidade:</label>
                <span></span>
            </div>

            <div class="form-group">
                <label>Estádio:</label>
                <span></span>
            </div>

            <div class="form-group">
                <input type="submit" value="Confirmar Exclusão" style="background-color: #f44336;">
                <a href="listarTimes">
                    <input type="button" value="Cancelar" style="background-color: #ccc; color: black;">
                </a>
            </div>

        </form>
    </div>

</body>
</html>