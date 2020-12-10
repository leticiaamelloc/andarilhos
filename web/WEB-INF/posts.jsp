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

                <div class="card" style="width: 18rem; margin:30px; word-break: break-all;">

                    <div class="card-body" style="border: solid 1px brown">
                        <h1 class="card-title" style="border-bottom: solid 1px brown; padding:20px;"><%=a.getTitulo()%></h1>
                        <p class="card-text" style="border-bottom: solid 1px brown; padding: 5px; margin-top: -5px;"><small class="text-muted">Categoria: <%=a.getCategoria().getDescricao()%></small></p>
                        <p class="card-text" style="border-bottom: solid 1px brown;  padding:10px; margin-top: -10px;"><%=a.getConteudo()%></p>
     
                    <ul class="list-group list-group-flush" style="list-style-type: none; text-align: left;">
                        <% for (Comentario c : a.getComentarios()) {%>
                        <li class="list-group-item" style="padding-bottom: 10px;" ><%=c.getComentario()%></li>
                            <% }%>
                    </ul>
                    </div>
                   
                </div>
                <% }%>
            </div>
        </div>
 
                    

    </div>
    <jsp:include page="footer.jsp" />
</body>

</html>
