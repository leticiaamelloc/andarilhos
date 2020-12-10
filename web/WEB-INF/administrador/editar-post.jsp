<%-- 
    Document   : destinos
    Created on : 17/11/2020, 17:31:22
    Author     : lcunha
--%>
<%@page import="model.Artigo"%>
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
        <% Artigo a = (Artigo) request.getAttribute("artigo"); %>

        <form class="needs-validation" id="edicao-post-form" method="POST" action="/administrador/editar-post">
            <h1 style="margin: 30px">
                Edite aqui a postagem!
            </h1>
            <% if (a != null) {%>
            <input type="hidden" name="id" value="<%=a.getId()%>">
             <input type="hidden" name="liberar" value="<%=a.getLiberar()%>">
              <input type="hidden" name="aprovado" value="<%=a.getAprovado()%>">
            <% } %>
            <div class="form-group" style="margin-top:20px;">
                <label>Titulo: *</label>
                <input type="text" class="form-control" required
                       value="<%if (a != null) {%><%=a.getTitulo()%><%}%>" name="titulo">
            </div>
            <div class="form-group" style="margin-top:20px;">
                <label>Categoria: *</label>
                <input type="text" class="form-control"required 
                       value="<%if (a != null) {%><%=a.getCategoria().getDescricao()%><%}%>" name="categoria">
            </div>

            <div class="form-group" style="margin-top:20px;">
                <label>Texto: *</label>
                <textarea name="conteudo" class="form-control" required><%if (a != null) {%><%=a.getConteudo()%><%}%></textarea>
            </div>

            <button type="submit" style="margin-top:20px;" class="btn btn-primary">Salvar</button>
        </form>

        <jsp:include page="../footer.jsp" />
    </body>

</html>
