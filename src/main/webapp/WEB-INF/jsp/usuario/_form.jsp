<%-- 
    Document   : _form
    Created on : 04/07/2014
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<form action="${PATH}usuario/salva" method="post" class="form-horizontal form-padding" role="form">
    <c:if test="${not empty entity.id}">
        <input type="hidden" name="entity.id" value="${entity.id}"/>
        <input type="hidden" name="_method" value="put"/>
    </c:if>
    <div class="form-group">
        <label for="nome" class="col-sm-2 control-label">Nome</label>
        <div class="col-sm-3">
            <input type="text" name="entity.nome" value="${fn:escapeXml(entity.nome)}" class="form-control" id="nome" placeholder="Informe o nome do usuário">
        </div>
    </div>
    <div class="form-group">
        <label for="login" class="col-sm-2 control-label">Login</label>
        <div class="col-sm-3">
            <input type="text" name="entity.login" value="${fn:escapeXml(entity.login)}" class="form-control" id="login" placeholder="Informe o login do usuário">
        </div>
    </div>
    <div class="form-group">
        <label for="senha" class="col-sm-2 control-label">Senha</label>
        <div class="col-sm-3">
            <input type="password" name="entity.senha" value="" class="form-control" id="senha" placeholder="Informe a senha do usuário">
        </div>
    </div>
    <div class="form-group">
        <label for="perfil" class="col-sm-2 control-label">Perfil</label>
        <div class="col-sm-3">
            <select class="form-control" id="perfil" name="entity.perfil">
                <option>- SELECIONE -</option>
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
</script>