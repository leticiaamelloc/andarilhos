<%-- 
    Document   : destinos
    Created on : 17/11/2020, 17:31:22
    Author     : lcunha
--%>
<%@page import="model.Artigo"%>
<%@page import="model.Comentario"%>
<%@ page import="model.Usuario" %>
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
               
                <%     Usuario user = (Usuario) request.getSession().getAttribute("user"); %>
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
                        <div class="row">
                            <div class="col">
                        <li class="list-group-item" style="padding-bottom: 20px; margin-top:20px;" ><%=c.getComentario()%></li>
                            </div>
                           
                                
                                <% if(c.getUsuario().getId() == user.getId()) {%>
                                 <div class="col" >
                         <a href="/administrador/editar-comentario?id=<%=c.getId()%>">
                       <img style=" max-width:30px; margin-bottom: 8px;" src="../../assets/img/editar.jpg" alt="" />
                    </a>
                        
                           
                        <a href="/administrador/excluir-comentario?id=<%=c.getId()%>">
                        <img style=" max-width:50px;" src="../../assets/img/excluir.png" alt="" />
                    </a>
                          </div>
                        <%}%>
                      
                        
                        </div>
                            <% }%>
                    </ul>
                  
                   
                </div>
                     <form class="card-body">
                      <input type="hidden" name="id" value="<%=a.getId()%>">

                    <textarea style="background: none; width: -webkit-fill-available; margin-top: 20px;" class="form-control"  name="comentario" placeholder="Escreva aqui seu comentário" rows="3"></textarea>

                    
                    <a href="/comentarista/posts?id=<%=a.getId()%>&comentario=<%=request.getParameter("comentario")%>">
                        <button class="btn btn-primary" type="submit" style="color:green; margin-top: 10px">Enviar Comentário</button>
                    </a>
                        </form>
                    </div>
                
                <% }%>
            </div>
        </div>


    </div>
    <jsp:include page="../footer.jsp" />
</body>

</html>
