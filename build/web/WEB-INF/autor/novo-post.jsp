<%-- 
    Document   : destinos
    Created on : 17/11/2020, 17:31:22
    Author     : lcunha
--%>

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

       	<form class="needs-validation" id="form-register" method="POST" action="/autor/novo-post">

            <h1 style="margin: 30px">
                Crie aqui sua nova postagem e em breve ela será publicada!
            </h1>

 <div class="form-group">
                <label>Titulo: *</label>
                <textarea class="form-control" style="width: 500px" rows="1" required name="titulo"></textarea>
            </div>
            <div class="form-group" style="margin-top: 30px">
                <label>Texto: *</label>
                <textarea class="form-control" style="width: 500px" rows="10" required name="conteudo"></textarea>
            </div>

            <div class="form-group"  style="margin-top: 30px">
                <label>Categoria: *</label>
                <textarea class="form-control" style="width: 500px" rows="1" required name="categoria"></textarea>
            </div>
          

            <button class="btn btn-primary" type="submit"  style="margin: 30px">Salvar</button>
        </form>


         <jsp:include page="../footer.jsp" />

    </body>


</html>
