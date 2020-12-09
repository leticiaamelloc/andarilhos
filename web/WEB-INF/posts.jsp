<%-- 
    Document   : destinos
    Created on : 17/11/2020, 17:31:22
    Author     : lcunha
--%>
<%@page import="model.Artigo"%>
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

        <jsp:include page="navbar.jsp" />

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
                    <label>Comentários:</label>
                    <ul class="list-group list-group-flush"style="border: solid 1px black;">
                        <% for (Comentario c : a.getComentarios()) {%>
                        <li class="list-group-item"><%=c.getComentario()%></li>
                            <% }%>
                    </ul>
                </div>
                <% }%>
            </div>
        </div>


    </div>
    <jsp:include page="footer.jsp" />
</body>

</html>
