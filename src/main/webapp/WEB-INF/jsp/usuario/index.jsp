<%-- 
    Document   : index
    Created on : 04/07/2014
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<c:set var="titulo_da_pagina" value="Lista de usuários"/>

<head>
    <title><fmt:message key='sistema.nome'/> | ${titulo_da_pagina}</title>
</head>

<body>
    <ol class="breadcrumb">
        <li><a href="${PATH}">Dashboard</a></li>
        <li class="active">Usuário</li>
        <span class="pageTitle">${titulo_da_pagina}</span>
    </ol>

    <div class="panel panel-default">
        <div class="panel-heading with-btn">
            <h3 class="panel-title pull-left">${titulo_da_pagina}</h3>
            <a href="${linkTo[UsuarioController].novo}" class="btn btn-primary btn-xs pull-right">Adicionar</a>
            <div class="clearfix"></div>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Perfil</th>
                    <th>Status</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${entityList}" var="entity">
                    <tr>
                        <td>${fn:escapeXml(entity.nome)}</td>
                        <td>${fn:escapeXml(entity.login)}</td>
                        <td>${fn:escapeXml(entity.perfil.nome)}</td>
                        <td>${entity.ativo ? 'Ativo' : 'Inativo'}</td>
                        <td><a href="${linkTo[UsuarioController].edita(entity.id)}">Editar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script type="text/javascript">
        activeMenu("#menu-usuarios");
    </script>
</body>
