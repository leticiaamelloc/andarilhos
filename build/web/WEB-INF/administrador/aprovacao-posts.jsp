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

        <div class="container">
            <div class="row">
                <% List<Artigo> artigos = (List<Artigo>) request.getAttribute("artigos");
                    for (Artigo a : artigos) {
                %>

                <div class="card" style="width: 18rem; margin:30px;">

                    <div class="card-body">
                        <h1 class="card-title"><%=a.getTitulo()%></h1>
                        <p class="card-text" style="border: solid 1px black;"><small class="text-muted">Categoria: <%=a.getCategoria().getDescricao()%></small></p>
                        <p class="card-text" style="border: solid 1px black;"><%=a.getConteudo()%></p>
                    </div>
                    <% if ("N".equals(a.getAprovado())) {%>
                    <a href="/administrador/aprovacao-posts?id=<%=a.getId()%>&aprovar=true">
                        <button class="btn btn-primary" type="submit" style="color:green">Aprovar Post</button>
                    </a>
                    <% } else {%>
                    <a href="/administrador/aprovacao-posts?id=<%=a.getId()%>&aprovar=false">
                        <button class="btn btn-primary" type="submit" style="color:red">Exluir Post</button>
                    </a>
                    <% } %>
                </div>
                <% }%>
            </div>
        </div>

        <jsp:include page="../footer.jsp" />
    </body>

</html>