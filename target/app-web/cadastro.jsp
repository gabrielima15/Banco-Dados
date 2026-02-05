<%@ page import="java.util.*,br.edu.ifpb.bd.model.Curso" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Time</title>
    <link rel="stylesheet" href="css/style.css"> </head>
<body>

    <div class="container">
        <h1>Novo Time</h1>
        <form>
            <div class="form-group">
                <label for="nome">Nome do Time:</label>
                <input type="text" id="nome" placeholder="Ex: Flamengo">
            </div>
            <div class="form-group">
                <label for="cidade">Cidade/Estado:</label>
                <input type="text" id="cidade" placeholder="Ex: Rio de Janeiro - RJ">
            </div>
            <div class="form-group">
                <label for="fundacao">Ano de Fundação:</label>
                <input type="number" id="fundacao" placeholder="Ex: 1895">
            </div>
            
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
        
        <a href="../index.html" class="btn btn-secondary">Voltar ao Menu</a>
    </div>

</body>
</html>
