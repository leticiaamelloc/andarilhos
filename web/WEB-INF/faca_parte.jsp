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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="../assets/fonts/css/style.css">
    <link rel="stylesheet" href="register.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/fonts/css/bootstrap-grid.css">

</head>
 
 <jsp:include page="navbar.jsp" />

    <body>   

    <form>

        <h1 style="margin: 30px">
            Faça Parte do nosso grupo!
        </h1>
        <h3> Deixe seu contato e retornaremos sua solicitação! </h3>
        <div class="form-group" style="margin: 30px">
          <label for="exampleFormControlInput1">Digite seu e-mail:</label>
          <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="nome@exemplo.com">
        </div>
        <div class="form-group" style="margin: 30px">
            <label for="exampleFormControlInput1">Digite seu celular:</label>
            <input type="tel" class="form-control" id="exampleFormControlInput2" placeholder="(00)00000-0000">
        </div>
        <div class="form-group" style="margin: 30px">
          <label for="exampleFormControlSelect2">Selecione:</label>
          <select class="form-control" id="exampleFormControlSelect2">
            <option></option>
            <option>Desejo postar minhas experiências no Blog </option>
            <option>Desejo comentar nos posts do Blog</option>
            <option>Desejo ter acesso como administrador do Blog</option>
          </select>
        </div>
        <div class="form-group">
          <label for="exampleFormControlTextarea1">Possui algo para nos dizer?</label>
          <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>

        <button class="btn btn-primary" type="submit"  style="margin: 30px">Enviar</button>
      </form>


      <div class="bg-cinza depoimento">

        <div class="container">

            <img src="../assets/img/perfil.png" alt="">

            <p><em>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip.</em></p>

            <span>Sérgio Brandão</span>

        </div>

    </div>

    <footer id="rodape">
        COPYRIGHT  TODOS OS DIREITOS RESERVADOS <br>
      
    </footer>

</body>

</html>