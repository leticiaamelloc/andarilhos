<%-- 
    Document   : destinos
    Created on : 17/11/2020, 17:31:22
    Author     : lcunha
--%>
<%@page import="model.Comentario"%>
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
        <% Comentario c = (Comentario) request.getAttribute("comentario"); %>

        <form class="needs-validation" id="edicao-post-form" method="POST" action="/administrador/editar-comentario">
            <h1 style="margin: 30px">
                Edite aqui o comentário!
            </h1>
            <% if (c != null) {%>
            <input type="hidden" name="id" value="<%=c.getId()%>">
              <input type="hidden" name="idArtigo" value="<%=c.getArtigo().getId()%>">
           
            <% } %>
            <div class="form-group" style="margin-top:20px;">
                <label>Comentário: *</label>
                <input type="text" class="form-control" required
                       value="<%if (c != null) {%><%=c.getComentario()%><%}%>" name="comentario">
            </div>
           

            <button type="submit" style="margin-top:20px;" class="btn btn-primary">Salvar</button>
        </form>

        <jsp:include page="../footer.jsp" />
    </body>

</html>
