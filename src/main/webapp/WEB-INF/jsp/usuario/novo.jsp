<%-- 
    Document   : novo
    Created on : 04/07/2014
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<c:set var="titulo_da_pagina" value="Novo usuário"/>

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
        <div class="panel-heading">
            <h3 class="panel-title pull-left">${titulo_da_pagina}</h3>
            <div class="clearfix"></div>
        </div>
        <c:import url="_form.jsp"/>  
    </div>

    <script type="text/javascript">
        activeMenu("#menu-usuarios");
    </script>

</body>
