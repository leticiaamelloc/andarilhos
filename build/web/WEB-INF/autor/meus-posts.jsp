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

        <jsp:include page="../navbar.jsp" />


        <div class="container">
            <div class="row">
                <% List<Artigo> artigos = (List<Artigo>) request.getAttribute("artigos");
                    for (Artigo a : artigos) {
                %>

                <div class="card" style="width: 18rem; margin:30px; word-break: break-all;">
                    
                    

                    <div class="card-body" style="border: solid 1px brown">
                        <h1 class="card-title" style="border-bottom: solid 1px brown; padding:20px;"><%=a.getTitulo()%></h1>
                        <p class="card-text" style="border-bottom: solid 1px brown; padding: 5px; margin-top: -5px;"><small class="text-muted">Categoria: <%=a.getCategoria().getDescricao()%></small></p>
                        <p class="card-text" style="padding:10px; margin-top: -5px;"><%=a.getConteudo()%></p>
                    </div>
                    <% if ("S".equals(a.getAprovado())) {%>
                      <ul class="list-group list-group-flush" style=" border-bottom: solid 1px brown;
    list-style-type: none;
    text-align: left;
    margin-top: 0;
    border-left: solid 1px brown;
    border-right: solid 1px brown;
    padding-top: 10px; list-style-type: none; text-align: left;">
                        <% for (Comentario c : a.getComentarios()) {%>
                        <li class="list-group-item" style="padding-bottom: 10px;" ><%=c.getComentario()%></li>
                            <% }%>
                    </ul>
                    <p class="card-text"><small class="text-muted" >Status: Post Liberado para o público</small></p>
                   
                    <% } else if ("S".equals(a.getLiberar())) {%>
                    <p class="card-text"><small class="text-muted">Status: Post aguardando aprovação do administrador</small></p>
                    <a href="/autor/meus-posts?id=<%=a.getId()%>&op=excluir">
                        <button class="btn btn-primary" type="submit" style="color:red;">Excluir</button>
                    </a>
                    <a href="/administrador/editar-post?id=<%=a.getId()%>">
                        <button class="btn btn-primary" type="submit">Editar</button>
                    </a>
                    <%  } else {%>
                    <p class="card-text"><small class="text-muted">Status: Post aguardando liberação do autor</small></p>
                    <a href="/autor/meus-posts?id=<%=a.getId()%>&op=liberar">
                        <button class="btn btn-primary" type="submit" style="color:green;">Liberar</button>
                    </a>
                    <a href="/autor/meus-posts?id=<%=a.getId()%>&op=excluir">
                        <button class="btn btn-primary" type="submit" style="color:red;">Excluir</button>
                    </a>
                    <a href="/administrador/editar-post?id=<%=a.getId()%>">
                        <button class="btn btn-primary" type="submit">Editar</button>
                    </a>
                    <% }%>

                </div>
                <% }%>
            </div>
        </div>

        <jsp:include page="../footer.jsp" />
    </body>

</html>
