<%-- 
    Document   : _form
    Created on : 04/07/2014
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<form id="form-usuario" action="${PATH}usuario/salva" method="post" class="form-horizontal form-padding" role="form">
    <c:if test="${not empty entity.id}">
        <input type="hidden" name="entity.id" value="${entity.id}"/>
        <input type="hidden" name="_method" value="put"/>
    </c:if>
    <div class="form-group">
        <label for="nome" class="col-sm-2 control-label">Nome</label>
        <div class="col-sm-3">
            <input type="text" maxlength="100" name="entity.nome" value="${fn:escapeXml(entity.nome)}" class="form-control required" id="nome" placeholder="Informe o nome do usu�rio">
        </div>
    </div>
    <div class="form-group">
        <label for="login" class="col-sm-2 control-label">Login</label>
        <div class="col-sm-3">
            <c:choose>
                <c:when test="${empty entity.id}">
                    <input type="text" maxlength="50" name="entity.login" value="${fn:escapeXml(entity.login)}" class="form-control required" id="login" placeholder="Informe o login do usu�rio">
                </c:when>
                <c:otherwise>
                    <p class="form-control-static">${fn:escapeXml(entity.login)}</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
        
    <c:if test="${empty entity.id}">
        <div class="form-group">
            <label for="senha" class="col-sm-2 control-label">Senha</label>
            <div class="col-sm-3">
                <input type="password" minlength="6" name="entity.senha" value="" class="form-control required" id="senha" placeholder="Informe a senha do usu�rio">
            </div>
        </div>
    </c:if>
    
    <div class="form-group">
        <label for="perfil" class="col-sm-2 control-label">Perfil</label>
        <div class="col-sm-3">
            <select class="form-control required" id="perfil" name="entity.perfil.id">
                <option value="">- SELECIONE -</option>
                <c:forEach items="${perfis}" var="p">
                    <c:set var="selected" value="${p.id eq entity.perfil.id ? 'selected' : ''}"/>
                    <option value="${p.id}" ${selected}>${p.nome}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-3">
            <label class="radio-inline">
                <input type="radio" name="entity.ativo" id="ativoTrue" value="1" ${entity.ativo ? 'checked' : ''}> Ativo
            </label>
            <label class="radio-inline">
                <input type="radio" name="entity.ativo" id="ativoFalse" value="0" ${entity.ativo ? '' : 'checked'}> Inativo
            </label>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-3">
            <div class="pull-right">
                <button type="submit" class="btn btn-primary">Salvar</button>
                <a href="${linkTo[UsuarioController].index}" class="btn btn-default">Voltar</a>
            </div>
        </div>
    </div>
</form>
<div class="clearfix"></div>

<script type="text/javascript">
    activeMenu("#menu-usuarios");
    validateForm('#form-usuario');
</script>