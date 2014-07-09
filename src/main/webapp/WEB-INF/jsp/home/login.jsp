<%-- 
    Document   : login
    Created on : 05/07/2014, 22:43:37
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="../../assets/ico/favicon.ico">
        <title><fmt:message key='sistema.nome'/> [Login]</title>

        <!-- Bootstrap core CSS -->
        <link href="${PATH}css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${PATH}css/signin.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="${PATH}js/ie10-viewport-bug-workaround.js"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="${PATH}js/html5ie8/html5shiv.js"></script>
          <script src="${PATH}js/html5ie8/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container">
            <form class="form-signin" role="form">
                <h2 class="form-signin-heading">Informe suas credenciais</h2>
                <input type="text" class="form-control" placeholder="Login de acesso" required autofocus>
                <input type="password" class="form-control" placeholder="Senha" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Acessar</button>
            </form>
        </div> <!-- /container -->
        
        <script src="${PATH}js/jquery.min.js"></script>
        <script src="${PATH}js/bootstrap.min.js"></script>
    </body>
</html>