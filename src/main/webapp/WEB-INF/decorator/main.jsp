<%-- 
    Document   : main
    Created on : 19/06/2014, 17:49:47
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="../../assets/ico/favicon.ico">
        <title><decorator:title default="<fmt:message key='sistema.nome'/>"/></title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/css/application.css"/>" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="<c:url value="/js/html5ie8/html5shiv.js"/>"></script>
          <script src="<c:url value="/js/html5ie8/respond.min.js"/>"></script>
        <![endif]-->

        <script src="<c:url value="/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/js/jquery.validate.min.js"/>"></script>
        <script src="<c:url value="/js/messages_pt_BR.min.js"/>"></script>
        <script src="<c:url value="/js/application.js"/>"></script>
    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="javascript:void(0)"><fmt:message key='sistema.nome'/></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav" id="navbartop">
                        <li class="active"><a href="${PATH}">Dashboard</a></li>
                        <li id="menu-usuarios"><a href="${PATH}usuarios">Usuários</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../navbar/">Default</a></li>
                        <li><a href="../navbar-static-top/">Static top</a></li>
                        <li class="active"><a href="./">Fixed top</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">

            <tags:messages messagesList="${success}" type="success" />
            <tags:messages messagesList="${info}" type="info" />
            <tags:messages messagesList="${warning}" type="warning" />
            <tags:messages messagesList="${errors}" type="danger" />

            <decorator:body/>

        </div> <!-- /container -->

        <div class="app-footer">
            <p>Desenvolvido por <a href="http://valdineireis.com.br" target="_blank">valdineireis</a>.</p>
            <p>
                <a href="#">Voltar para o Topo</a>
            </p>
        </div>
    </body>
</html>
