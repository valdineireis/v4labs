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
        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/css/signin.css"/>" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="<c:url value="/js/ie10-viewport-bug-workaround.js"/>"></script>

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="<c:url value="/js/html5ie8/html5shiv.js"/>"></script>
          <script src="<c:url value="/js/html5ie8/respond.min.js"/>"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary form-signin">
                <div class="panel-heading">
                    <h3 class="panel-title">Controle de Acesso</h3>
                </div>
                <div class="panel-body">
                    <form class="" role="form">
                        <input type="text" class="form-control" placeholder="Login de acesso" required autofocus>
                        <input type="password" class="form-control" placeholder="Senha" required>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Relembre-me
                            </label>
                        </div>
                        <input name="redirectUrl" value="${redirectUrl}" type="hidden" />
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Acessar</button>
                    </form>
                </div>
            </div>
        </div> <!-- /container -->

        <script src="<c:url value="/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    </body>
</html>