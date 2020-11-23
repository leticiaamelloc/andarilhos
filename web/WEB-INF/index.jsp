<%-- 
    Document   : index
    Created on : 17/11/2020, 17:36:25
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

</head>
<body>    
<div id= "opacidade">

<div id = "popup">
  <span id="fechar"><a>X</a></span>
<img src="../assets/img/jalapao.jpg" alt="">
</div>

</div>
     <jsp:include page="navbar.jsp" />
    
    <div id="banner">
        <img src="../assets/img/banner1.jpg" alt="">
        <img src="../assets/img/banner2.jpg" alt="">
        <img src="../assets/img/banner3.jpg" alt="">
    </div>

    <div class="container">

        <div class="flex space-between">
            <article class="coluna-superior">
                <h1>Hà Giang – Vietnã</h1>
                <img src="../assets/img/ha-giang.jpg" alt="">
                <p>Lorem ipsum dolor sit amet, consect etur adipiscing elit. Vestibulum elem entum tincidunt ligula ultrices dapibus. In ac elit vel enim ornare elementum a nec orci  metus tempus. 
                <p>As maecenas libero tellus, convallis quis turpis a, fermentum asclast dictum purus. Ut sed rhoncus ex, quis gravida justo. Pellentesque pretium metus mi, et venenatis metus tempus.</p></p>

                <a href="#" class="btn">Saiba mais</a>

            </article>

            <article class="coluna-superior">
                <h1>Surat Thani – Tailândia</h1>
                <img src="../assets/img/surat-thani.jpg" alt="">
                <p>Lorem ipsum dolor sit amet, consect etur adipiscing elit. Vestibulum elem entum tincidunt ligula ultrices dapibus. In ac elit vel enim ornare elementum a nec orci  metus tempus. 
                <p>As maecenas libero tellus, convallis quis turpis a, fermentum asclast dictum purus. Ut sed rhoncus ex, quis gravida justo. Pellentesque pretium metus mi, et venenatis metus tempus.</p></p>

                <a href="#" class="btn">Saiba mais</a>
            </article>
        </div>


        <div class="linha">
            <img src="../assets/img/aviao.png" alt="">
        </div>



        <div class="flex space-between">

            <section class="coluna-inferior">
                <h2>Quem Somos</h2>
                <img src="../assets/img/quem_somos.PNG" alt="">
                <p>Lorem ipsum dolor sit amet innc, consectetur adipiscing elit. Nulla semper, sem eget blandit auctor, am libero dapibus erat, aullam uccorper nisi quam sed donec auctor cursus tortor ettius last.</p>
                <a href="/quem_somos" class="btn">Saiba mais</a>
            </section>

            <section class="coluna-inferior">
                <h2>Nossos Destinos</h2>
                <img src="../assets/img/nossos_destinos.jpg" alt="">
                <p>Lorem ipsum dolor sit amet innc, consectetur adipiscing elit. Nulla semper, sem eget blandit auctor, am libero dapibus erat, aullam uccorper nisi quam sed donec auctor cursus tortor ettius last.</p>
                <a href="/destinos" class="btn">Saiba mais</a>
            </section>

            <section class="coluna-inferior">
                <h2>Faça parte do nosso grupo</h2>
                <img src="../assets/img/faca_parte.jpg" alt="">
                <p>Lorem ipsum dolor sit amet innc, consectetur adipiscing elit. Nulla semper, sem eget blandit auctor, am libero dapibus erat, aullam uccorper nisi quam sed donec auctor cursus tortor ettius last.</p>
                <a href="/faca_parte" class="btn">Saiba mais</a>
            </section>

        </div>

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