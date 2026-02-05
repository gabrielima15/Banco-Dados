<%@ page import="java.util.*,br.edu.ifpb.bd.dto.AlunoDTO" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Times</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="container">
        <h1>Times Cadastrados</h1>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Flamengo</td>
                    <td class="actions">
                        <a href="#" class="btn btn-edit">Editar</a>
                        <a href="#" class="btn btn-delete">Excluir</a>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Palmeiras</td>
                    <td class="actions">
                        <a href="#" class="btn btn-edit">Editar</a>
                        <a href="#" class="btn btn-delete">Excluir</a>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>São Paulo</td>
                    <td class="actions">
                        <a href="#" class="btn btn-edit">Editar</a>
                        <a href="#" class="btn btn-delete">Excluir</a>
                    </td>
                </tr>
            </tbody>
        </table>

        <a href="../index.html" class="btn btn-secondary">Voltar ao Menu</a>
    </div>

</body>
</html>