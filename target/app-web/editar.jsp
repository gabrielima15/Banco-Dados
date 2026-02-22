<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/style.css">
<%
    // --- JAVA SIMULADO (Para o HTML não quebrar) ---
    // Depois você substituirá isso pela conexão real com o banco
    
    // Simulando que recuperamos o Time #1
    int id = 1; 
    String nomeAtual = "Time Exemplo FC";
    int idTecnicoAtual = 10;
    boolean timeEncontrado = true;
    
    // Variáveis de mensagem vazias
    String mensagem = "";
    String tipoMensagem = "";
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Time</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="container">
        <h1>Editar Time <%= (id > 0 ? "#" + id : "") %></h1>

        <% if(timeEncontrado) { %>
            <form method="post" action="editar.jsp">
                <div class="form-group">
                    <label>Nome do Time:</label>
                    <input type="text" name="nome" value="<%= nomeAtual %>" required>
                </div>
                
                <div class="form-group">
                    <label>ID do Técnico:</label>
                    <input type="number" name="id_tecnico" value="<%= idTecnicoAtual %>" required>
                </div>

                <div class="form-actions">
                    <button type="button" class="btn btn-primary">Salvar Time (Demo)</button>
                    <a href="listarTimes.jsp" class="btn btn-secondary" style="margin-top:0;">Voltar</a>
                </div>
            </form>

            <div class="separator"></div>

            <h3 class="section-title">👟 Elenco</h3>
            
            <div class="player-actions">
                <a href="#" class="btn btn-outline">Ver Lista</a>
                
                <button type="button" class="btn btn-outline" onclick="abrirModal()">+ Add Jogador</button>
            </div>

        <% } else { %>
            <p>Time não encontrado.</p>
        <% } %>
    </div>

    <div id="modalJogador" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="fecharModal()">&times;</span>
            
            <h2 style="border:none;">Novo Jogador</h2>
            <p style="margin-bottom: 15px; color: #666;">Adicionando ao time: <strong><%= nomeAtual %></strong></p>
            
            <form method="post" action="#">
                <div class="form-group">
                    <label>Nome do Jogador:</label>
                    <input type="text" name="nome_jogador" placeholder="Ex: Neymar">
                </div>
                
                <div class="form-group">
                    <label>Posição:</label>
                    <select name="posicao">
                        <option value="Atacante">Atacante</option>
                        <option value="Meio-Campo">Meio-Campo</option>
                        <option value="Zagueiro">Zagueiro</option>
                        <option value="Goleiro">Goleiro</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label>Número da Camisa:</label>
                    <input type="number" name="numero_camisa" style="width: 80px;">
                </div>
                
                <button type="button" class="btn btn-primary" onclick="alert('Botão funcionou! (Lógica Java virá depois)')">Cadastrar</button>
            </form>
        </div>
    </div>

<script>
    var modal = document.getElementById("modalJogador");

    function abrirModal() {
        // Use 'flex' para o CSS centralizar ele na tela
        modal.style.display = "flex";
    }

    function fecharModal() {
        modal.style.display = "none";
    }

    // Fecha se clicar fora da caixa branca
    window.onclick = function(event) {
        // O NetBeans prefere '===' (estritamente igual)
        if (event.target === modal) {
            fecharModal();
        }
    }; // Adicionado ponto e vírgula aqui
</script>
</body>
</html>