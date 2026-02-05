<%@ page import="java.util.*,br.edu.ifpb.bd.model.Aluno" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabela do Campeonato</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

    <div class="container">
        <h1>Classificação Atual</h1>
        
        <table>
            <thead>
                <tr>
                    <th>Pos</th>
                    <th>Time</th>
                    <th>Pontos</th>
                    <th>Jogos</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1º</td>
                    <td>Flamengo</td>
                    <td>45</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>2º</td>
                    <td>Palmeiras</td>
                    <td>42</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>3º</td>
                    <td>Botafogo</td>
                    <td>40</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>4º</td>
                    <td>Fortaleza</td>
                    <td>38</td>
                    <td>20</td>
                </tr>
            </tbody>
        </table>

        <a href="/index.html" class="btn btn-secondary">Voltar ao Menu</a>
    </div>

</body>
</html>