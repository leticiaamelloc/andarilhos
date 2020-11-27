<%-- 
    Document   : navbar
    Created on : 17/11/2020, 19:16:29
    Author     : lcunha
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Usuario" %>
<%@ page import="enums.TipoUsuario" %>

<header id="topo">
    <% Usuario user = (Usuario) request.getSession().getAttribute("user");
        if (user == null) { %>
    <div id="logo">

        <img src="../assets/img/logo.png" alt="">
    </div>

    <div id="btn-menu">
        <div class="barra"></div>                
        <div class="barra"></div>                
        <div class="barra"></div>
    </div>

    <nav id="menu">
        <ul>
            <li><a href="index">Home</a></li>
            <li><a href="quem_somos">Quem Somos</a></li>
            <li>
                <a href="destinos">Destinos</a>
            </li>
            <li><a href="faca_parte">Faça Parte </a></li>
            <li><a href="/login">Entrar</a></li>
        </ul>
    </nav>

    <% } else {%>
    <div id="logo">

        <img src="../../assets/img/logo.png" alt="">
    </div>

    <div id="btn-menu">
        <div class="barra"></div>                
        <div class="barra"></div>                
        <div class="barra"></div>
    </div>

    <nav id="menu">
        <ul>
            <li><a href="../index">Home</a></li>
            <li><a href="../quem_somos">Quem Somos</a></li>
            <li>
                <a href="../destinos">Destinos</a>
            </li>
            <%  TipoUsuario tipo = user.getTipo();
                if (tipo.equals(TipoUsuario.ADMIN)) {%>
            <li class="nav-item"><a class="nav-link">Área do administrador</a>
                <ul>
                    <li><a href="/administrador/aprovacao-cadastro">Cadastros Pendentes</a></li>
                </ul> 
            </li>
            <%} else if (tipo.equals(TipoUsuario.AUTOR)) { %>
            <li class="nav-item"><a class="nav-link">Área do autor</a>
                <ul>
                    <li><a href="/autor/meus-posts">Meus Posts</a></li>
                    <li><a href="/autor/novo-post">Novo Post</a></li>  
                </ul> 

            </li>
            <%} else if (tipo.equals(TipoUsuario.COMENTARISTA)) { %>
            <li class="nav-item"><a class="nav-link">Área do comentarista</a></li>
                <%} %>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>

        </ul>
    </nav>
    <% }%>
</header>


