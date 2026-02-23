<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, bd.model.Jogador, bd.dao.JogadorDAO" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Elenco do Time</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listtime.css">
</head>
<body>
    <div class="container-list"> 
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
            <h1 style="margin-bottom: 0; border: none;">Elenco do Time</h1>
            <a href="cadastrarJogador.jsp?idTime=<%= request.getParameter("idTime") %>" class="btn btn-primary" style="width: auto;">+ Novo Jogador</a>
        </div>

        <table class="table-custom"> 
            <thead>
                <tr>
                    <th>Foto</th>
                    <th>Nome do Jogador</th>
                    <th>Posição</th>
                    <th style="text-align: center;">Camisa</th>
                    <th style="text-align: center;">Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    try {
                        String idTimeStr = request.getParameter("idTime");
                        if (idTimeStr != null) {
                            int idTime = Integer.parseInt(idTimeStr);
                            JogadorDAO dao = new JogadorDAO();
                            List<Jogador> lista = dao.listarPorTime(idTime);
                            
                            if (lista.isEmpty()) {
                %>
                    <tr><td colspan="5" style="text-align: center;">Nenhum jogador cadastrado para este time.</td></tr>
                <%
                            } else {
                                for(Jogador j : lista) {
                %>
                    <tr>
                        <td style="width: 50px; text-align: center;">
                            <% if(j.getCaminhoFoto() != null && !j.getCaminhoFoto().trim().isEmpty()) { %>
                                <img src="<%= j.getCaminhoFoto() %>" alt="Foto" class="escudo-img">
                            <% } else { %>
                                <span class="escudo-placeholder">👤</span>
                            <% } %>
                        </td>
                        <td><strong><%= j.getNome() %></strong></td>
                        <td><%= j.getPosicao() %></td>
                        <td style="text-align: center;"><%= j.getnCamisa() %></td>
                        <td class="actions-cell" style="justify-content: center;">
                            <button type="button" class="btn-edit" style="border:none; cursor:pointer;" 
                                    onclick="openEditModal('<%= j.getId() %>', '<%= j.getNome() %>', '<%= j.getnCamisa() %>', '<%= j.getPosicao() %>', '<%= j.getCaminhoFoto() %>', '<%= j.getIdTime() %>')">
                                ✏️
                            </button>
                            
                            <a href="ExcluirJogadorServlet?id=<%= j.getId() %>&idTime=<%= j.getIdTime() %>" 
                               class="btn btn-delete" 
                               onclick="return confirm('Excluir o jogador <%= j.getNome() %>?')">🗑️</a>
                        </td>
                    </tr>
                <% 
                                }
                            }
                        }
                    } catch(Exception e) {
                %>
                    <tr><td colspan="5" style="color: red; text-align: center;">Erro: <%= e.getMessage() %></td></tr>
                <% } %>
            </tbody>
        </table>

        <div style="margin-top: 20px;">
            <a href="listarTimes.jsp" class="btn btn-secondary">Voltar para Times</a>
        </div>
    </div>

    <div id="editModal" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="closeModal()">&times;</span>
            <h2 style="margin-bottom: 20px; border-bottom: 1px solid #eee; padding-bottom: 10px;">Editar Atleta</h2>
            
            <form action="EditarJogadorServlet" method="post">
                <input type="hidden" id="editId" name="id">
                <input type="hidden" id="editIdTime" name="idTime">

                <div class="form-group">
                    <label>Nome do Atleta:</label>
                    <input type="text" id="editNome" name="nome" required>
                </div>

                <div class="form-row" style="display: flex; gap: 15px;">
                    <div class="form-group" style="flex: 1;">
                        <label>Camisa:</label>
                        <input type="number" id="editCamisa" name="camisa" required min="1" max="99">
                    </div>
                    <div class="form-group" style="flex: 1;">
                        <label>Posição:</label>
                        <select id="editPosicao" name="posicao" required>
                            <option value="Goleiro">Goleiro</option>
                            <option value="Zagueiro">Zagueiro</option>
                            <option value="Meia">Meia</option>
                            <option value="Atacante">Atacante</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label>URL da Foto:</label>
                    <input type="text" id="editFoto" name="foto">
                </div>

                <div class="form-actions" style="margin-top: 20px;">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Atualizar Dados</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function openEditModal(id, nome, camisa, posicao, foto, idTime) {
            document.getElementById('editId').value = id;
            document.getElementById('editNome').value = nome;
            document.getElementById('editCamisa').value = camisa;
            document.getElementById('editPosicao').value = posicao;
            document.getElementById('editFoto').value = (foto === 'null' || foto === 'undefined') ? '' : foto;
            document.getElementById('editIdTime').value = idTime;
            document.getElementById('editModal').style.display = 'flex';
        }

        function closeModal() {
            document.getElementById('editModal').style.display = 'none';
        }

        window.onclick = function(event) {
            var modal = document.getElementById('editModal');
            if (event.target === modal) {
                closeModal();
            }
        };
    </script>
</body>
</html>