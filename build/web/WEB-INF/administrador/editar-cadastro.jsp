<%-- 
    Document   : destinos
    Created on : 17/11/2020, 17:31:22
    Author     : lcunha
--%>
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Andarilhos</title>
        <link rel="stylesheet" href="../../assets/fonts/kill.css">
        <link rel="stylesheet" href="../../assets/fonts/css/style.css">
        <link rel="stylesheet" type="text/css" href="../../assets/fonts/css/bootstrap-grid.css">


    </head>
    <body>   

        <jsp:include page="../navbar.jsp" />
        <% Usuario u = (Usuario) request.getAttribute("usuario"); %>



        <form class="needs-validation" id="edicao-post-form" method="POST" action="/administrador/editar-cadastro">
            <h1 style="margin: 30px">
                Edite aqui o usuário!
            </h1>
            <% if (u != null) {%>
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <input type="hidden" name="cadastroAprovado" value="<%=u.getCadastroAprovado()%>">
            <% } %>
            <div class="form-group" style="margin-top:20px;">
                <label form="form-register">Nome:</label>
                <input type="text" name="nome" value="<%if (u.getNome() != null) {%><%=u.getNome()%><%}%>">

            </div>
            <div class="form-group" style="margin-top:20px;">
                <label >E-mail: * </label>
                <input 	 type="email" required name="email" value="<%if (u.getEmail() != null) {%><%=u.getEmail()%><%}%>">
            </div>

            <div class="form-group" style="margin-top:20px;">
                <label>Cpf: * </label>
                <input type="text" 
                       required name="cpf" value="<%if (u != null && u.getCpf() != null) {%><%=u.getCpf()%><%}%>">
            </div>

            <div class="form-group" style="margin: 30px">
                <label>Selecione: * </label>
                <select  required name="papel">
                    <%if (u != null && u.getPapel() == 0) {%>

                    <option>Desejo ter acesso como administrador do Blog</option>
                    <option>Desejo ser autor(a) do Blog</option>
                    <option>Desejo comentar nos posts do Blog</option>
                    <%}%>
                    <%if (u != null && u.getPapel() == 1) {%><option>Desejo ser autor(a) do Blog</option>
                    <option>Desejo comentar nos posts do Blog</option>
                    <option>Desejo ter acesso como administrador do Blog</option>
                    <%}%>
                    <%if (u != null && u.getPapel() == 2) {%><option>Desejo comentar nos posts do Blog</option>
                    <option>Desejo ser autor(a) do Blog</option>
                    <option>Desejo ter acesso como administrador do Blog</option>
                    <%}%>     

                </select>
            </div>
            <div class="form-group" style="margin: 30px">
                <label>Senha: * </label>
                <input type="password" required value="<%if (u != null && u.getSenha() != null) {%><%=u.getSenha()%><%}%>" name="senha">
            </div>

            <button type="submit" style="margin-top:20px;" class="btn btn-primary">Salvar</button>
        </form>

        <jsp:include page="../footer.jsp" />
    </body>

</html>
