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
                    for (Artigo m : artigos) {
                %>
               
                    <div class="card" style="width: 18rem; margin:30px;">

                        <div class="card-body">
                            <h1 class="card-title"><%=m.getTitulo()%></h1>
                            <p class="card-text"><%=m.getConteudo()%></p>
                              <p class="card-text"><small class="text-muted">Categoria: <%=m.getCategoria().getDescricao()%></small></p>
                                <% if (m.getAprovado() == "S") {%>
                                 <p class="card-text"><small class="text-muted">Status: Post Liberado para o público</small></p>
                             <% } else if (m.getLiberar() == "S") {%>
                                   <p class="card-text"><small class="text-muted">Status: Post aguardando aprovação do administrador</small></p>
                            <%  } else {%>
                            <button class="btn btn-primary">Liberar Post</button>
                             <% }%>
                            
                           

                        </div>
                    </div>
              



                     <% }%>
            </div>
        </div>


    </div>
    <jsp:include page="../footer.jsp" />
</body>

</html>
