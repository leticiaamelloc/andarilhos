<%-- 
    Document   : llogin
    Created on : 17/11/2020, 17:29:12
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
   

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

    <script>
        $(document).ready(function(){
          
            //ao clicar no btn-menu
            $("#btn-menu").click(function(){
                $("#menu").slideToggle(500); //mostra/esconde o menu

                $("#btn-menu").toggleClass("x"); //add/remove a classe "x"

            });

             $("#fechar").click(function(){
                $("#opacidade").fadeOut(500);
            });



          $('#banner').bxSlider({
              mode:'horizontal',
              randomStart: true,
              auto: true,
              pause: 4000,
              autoHover: true
          });

        });
    </script>

    <script>
        $('#myModal').on('shown.bs.modal', function () {
             $('#myInput').trigger('focus')
        })
    </script>

    

</head>
 

    <jsp:include page="navbar.jsp" />
<!--Lgin-->

<body>   

<form method="POST" action="login">
<div class="form-group" style="margin: 30px;">
    <label for="cpf">Digite seu CPF *</label>
    <input class="form-control" type="text" name="cpf" type="text" required />
</div>
<!-- Senha -->
<div class="form-group" style="margin: 30px">
    <label class=" form-margin-fix" for="Senha">Digite sua senha *</label>
    <input class="form-control  form-margin-fix" type="password"name="senha" required />
</div>


<!-- login -->
<button class="btn btn-primary" type="submit">Entrar</button>
</form>
</main>


  </div>
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