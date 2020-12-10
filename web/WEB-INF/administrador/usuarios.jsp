<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
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
            <h1 style="margin: 30px">
                Usuários
            </h1>
            <table class="table table-responsive-md table-hover table-striped table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                        for (Usuario a : usuarios) {%>
                    <tr>
                        <th scope="row"><%=a.getId()%></th>
                        <td><%=a.getCpf()%></td>
                        <td><%=a.getNome()%></td>
                        <td><%=a.getEmail()%></td>


                        <% if (a.getPapel() == 0) {%>
                        <td>Administrador</td>

                        <%}%>
                        <% if (a.getPapel() == 1) {%>
                        <td>Autor</td>

                        <%}%>
                        <% if (a.getPapel() == 2) {%>
                        <td>Comentarista</td>
                        <%}%>     


                        <td>
                            <a href="/administrador/editar-cadastro?id=<%=a.getId()%>">
                                <button type="button" class="btn btn-outline-danger">Editar</button>
                            </a>
                        </td>
                        <td>
                            <a href="/administrador/usuarios?id=<%=a.getId()%>&op=deletar">
                                <button type="button" style="color:red;" class="btn btn-outline-danger">Deletar</button>
                            </a>
                        </td>
                        <% if ("N".equals(a.getCadastroAprovado())) {%>
                        <td>

                            <a href="/administrador/usuarios?id=<%=a.getId()%>&op=aprovar">
                                <button type="button" style="color:green;" class="btn btn-outline-primary">Aprovar</button>
                            </a>
                        </td>
                        <% } %>


                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <jsp:include page="../footer.jsp" />
    </body>
</html>