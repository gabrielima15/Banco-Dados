<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.Campeonato, bd.dao.CampeonatoDAO" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Campeonatos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
            <h1 style="margin: 0;">Campeonatos Disponíveis</h1>
            <button type="button" class="btn btn-primary" onclick="openModal()" style="width: auto;">+ Novo Campeonato</button>
        </div>
        
        <table class="table-custom">
            <thead>
                <tr>
                    <th style="width: 80px; text-align: center;">ID</th>
                    <th>Nome do Campeonato</th>
                    <th style="width: 150px; text-align: center;">Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    try {
                        CampeonatoDAO dao = new CampeonatoDAO();
                        List<Campeonato> lista = dao.listar();
                        
                        if (lista.isEmpty()) {
                %>
                    <tr>
                        <td colspan="3" style="text-align: center;">Nenhum campeonato encontrado no banco de dados.</td>
                    </tr>
                <%
                        } else {
                            for(Campeonato c : lista) {
                %>
                    <tr>
                        <td style="text-align: center;"><%= c.getId() %></td>
                        <td><strong><%= c.getNome() %></strong></td>
                        <td style="text-align: center;">
                            <%-- Botão de exclusão (opcional, mas útil) --%>
                            <a href="ExcluirCampeonatoServlet?id=<%= c.getId() %>" 
                               class="btn btn-delete" 
                               style="padding: 5px 10px;"
                               onclick="return confirm('Excluir este campeonato?')">🗑️</a>
                        </td>
                    </tr>
                <% 
                            }
                        }
                    } catch(Exception e) { 
                %>
                    <tr>
                        <td colspan="3" style="color: red; text-align: center;">Erro ao carregar: <%= e.getMessage() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <div style="margin-top: 20px;">
            <a href="index.jsp" class="btn btn-secondary">Voltar ao Menu</a>
        </div>
    </div>

    <div id="campModal" class="modal">
        <div class="modal-content" style="max-width: 450px;">
            <span class="close-btn" onclick="closeModal()">&times;</span>
            <h2 style="margin-bottom: 20px; border-bottom: 1px solid #eee; padding-bottom: 10px;">Novo Campeonato</h2>
            
            <form action="CadastrarCampeonatoServlet" method="post">
                <div class="form-group" style="text-align: left;">
                    <label style="font-weight: bold; display: block; margin-bottom: 8px;">Nome do Campeonato:</label>
                    <input type="text" name="nomeCampeonato" required placeholder="Ex: Campeonato Brasileiro 2026" 
                           style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px;">
                </div>
                
                <div class="form-actions" style="margin-top: 20px;">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Salvar Campeonato</button>
                </div>
            </form>
        </div>
    </div>

    <%-- java scriptzinho de cria --%>
    <script>
        function openModal() {
            document.getElementById('campModal').style.display = 'flex';
        }

        function closeModal() {
            document.getElementById('campModal').style.display = 'none';
        }

        // Fecha o modal se o usuário clicar fora da caixa branca
        window.onclick = function(event) {
            var modal = document.getElementById('campModal');
            if (event.target === modal) {
                closeModal();
            }
        };
    </script>
</body>
</html>