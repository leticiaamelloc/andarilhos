<%-- 
    Document   : faca_parte
    Created on : 17/11/2020, 17:31:49
    Author     : lcunha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Andarilhos</title>
        <link rel="stylesheet" href="../assets/fonts/kill.css">
        <link rel="stylesheet" href="../assets/fonts/css/style.css">
    </head>
    <body>    

        <jsp:include page="navbar.jsp" />

        <form class="needs-validation" id="form-register" method="POST" action="/faca_parte">

            <h1 style="margin: 30px">
                Faça Parte do nosso grupo!
            </h1>
            <h3> Deixe seu contato e retornaremos sua solicitação! </h3>
            <div class="form-group"  style="margin: 30px">
                <label form="form-register">Digite seu nome:</label>
                <input type="text" name="nome">

            </div>
            <div class="form-group" style="margin: 30px">
                <label >Digite seu e-mail: * </label>
                <input 	 type="email" required name="email">
            </div>
            <div class="form-group" style="margin: 30px">
                <label>Digite seu cpf: * </label>
                <input type="text" 
                       required name="cpf">
            </div>
            <div class="form-group" style="margin: 30px">
                <label>Selecione: * </label>
                <select  required name="papel">
                    <option></option>
                    <option>Desejo ser autor(a) do Blog</option>
                    <option>Desejo comentar nos posts do Blog</option>
                    <option>Desejo ter acesso como administrador do Blog</option>
                </select>
            </div>
            <div class="form-group" style="margin: 30px">
                <label>Digite sua senha: * </label>
                <input type="password" required name="senha">
            </div>

            <button class="btn btn-primary" type="submit"  style="margin: 30px">Enviar</button>
        </form>


        <jsp:include page="footer.jsp" />

    </body>

</html>