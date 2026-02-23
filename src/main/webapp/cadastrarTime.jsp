<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.Campeonato, bd.dao.CampeonatoDAO" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Novo Time</title>
    <%-- CORREÇÃO: Uso do contextPath para garantir o carregamento do CSS --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/casdastrostyle.css"> 
</head>
<body>
    <div class="container-cadastro"> 
        <div class="header-cadastro">
            <h1>Cadastrar Novo Equipe</h1>
        </div>

        <form method="post" action="CadastrarTimeServlet">
            
            <div class="form-group">
                <label>Nome do Time:</label>
                <input type="text" name="nome" required placeholder="Ex: Flamengo" class="form-control">
            </div>
     
            <div class="form-row" style="display: flex; gap: 15px;">
                <div class="form-group" style="flex: 1;">
                    <label>Cidade (Sede):</label>
                    <input type="text" name="cidade" required placeholder="Ex: Rio de Janeiro" class="form-control">
                </div>
                
                <div class="form-group" style="flex: 1;">
                    <label>Nome do Técnico:</label>
                    <input type="text" name="tecnico" required placeholder="Ex: Tite" class="form-control">
                </div>
            </div>

            <div class="form-group">
                <label>URL do Escudo:</label>
                <input type="text" name="escudo" placeholder="Link da imagem (PNG/JPG)" class="form-control">
            </div>

            <div class="form-group">
                <label>Campeonato:</label>
                <div style="display: flex; gap: 10px;">
                    <select name="idCampeonato" required class="form-control" style="flex: 1;">
                        <option value="">-- Selecione o Campeonato --</option>
                        <%
                            try {
                                CampeonatoDAO campDao = new CampeonatoDAO();
                                List<Campeonato> campeonatos = campDao.listar();
                                for(Campeonato c : campeonatos) {
                        %>
                            <option value="<%= c.getId() %>"><%= c.getNome() %></option>
                        <% 
                                }
                            } catch(Exception e) { 
                                out.print("<option>Erro ao carregar campeonatos</option>");
                            }
                        %>
                    </select>
                    <%-- Botão "+" para abrir o modal de novo campeonato --%>
                    <button type="button" class="btn btn-primary" onclick="openCampModal()" style="width: auto; padding: 0 15px;">+</button>
                </div>
            </div>

            <div class="form-actions" style="margin-top: 25px;">
                <button type="submit" class="btn btn-primary" style="width: 100%;">Salvar Time</button>
                <a href="index.jsp" class="btn btn-secondary" style="display: block; text-align: center; margin-top: 10px;">Voltar ao Menu</a>
            </div>
        </form>
    </div>


    <div id="campModal" class="modal">
        <div class="modal-content" style="max-width: 400px;">
            <span class="close-btn" onclick="closeCampModal()">&times;</span>
            <h2 style="margin-bottom: 20px;">Novo Campeonato</h2>
            <form action="CadastrarCampeonatoServlet" method="post">
                <div class="form-group">
                    <label>Nome do Campeonato:</label>
                    <input type="text" name="nomeCampeonato" required placeholder="Ex: Brasileirão 2026" class="form-control">
                </div>
                <div class="form-actions" style="margin-top: 20px;">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function openCampModal() { document.getElementById('campModal').style.display = 'flex'; }
        function closeCampModal() { document.getElementById('campModal').style.display = 'none'; }
        window.onclick = function(event) {
            if (event.target === document.getElementById('campModal')) closeCampModal();
        };
    </script>
</body>
</html>