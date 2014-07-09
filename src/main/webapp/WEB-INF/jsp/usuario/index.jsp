<%-- 
    Document   : index
    Created on : 04/07/2014
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<head>
    <title><fmt:message key='sistema.nome'/> | Usu�rio [Listagem]</title>
</head>

<body>
    <ol class="breadcrumb">
        <li><a href="${PATH}">Dashboard</a></li>
        <li class="active">Usu�rio</li>
        <span class="pageTitle">Lista de usu�rios</span>
    </ol>

    <h1>Usu�rios <a href="${linkTo[UsuarioController].novo}" class="btn btn-primary btn-lg pull-right">Adicionar</a></h1>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Login</th>
                <th>Status</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${entityList}" var="entity">
                <tr>
                    <td>${entity.id}</td>
                    <td>${entity.nome}</td>
                    <td>${entity.login}</td>
                    <td>${entity.ativo ? 'Ativo' : 'Inativo'}</td>
                    <td><a href="${linkTo[UsuarioController].edita(entity.id)}">Editar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
