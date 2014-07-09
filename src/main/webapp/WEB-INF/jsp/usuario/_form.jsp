<%-- 
    Document   : _form
    Created on : 04/07/2014
    Author     : Valdinei Reis (valdineimtz@gmail.com) (http://valdineireis.com.br/)
--%>
<form action="${PATH}usuario/salva" method="post" role="form">
    <c:if test="${not empty entity.id}">
        <input type="hidden" name="entity.id" value="${entity.id}"/>
        <input type="hidden" name="_method" value="put"/>
    </c:if>
    <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" name="entity.nome" value="${entity.nome}" class="form-control" id="nome" placeholder="Informe o nome do usuário">
    </div>
    <div class="form-group">
        <label for="login">Login</label>
        <input type="text" name="entity.login" value="${entity.login}" class="form-control" id="login" placeholder="Informe o login do usuário">
    </div>
    <div class="form-group">
        <label for="senha">Senha</label>
        <input type="password" name="entity.senha" value="" class="form-control" id="senha" placeholder="Informe a senha do usuário">
    </div>
    <div class="form-group">
        <label class="radio-inline">
            <input type="radio" name="entity.ativo" id="ativoTrue" value="1" ${entity.ativo ? 'checked' : ''}> Ativo
        </label>
        <label class="radio-inline">
            <input type="radio" name="entity.ativo" id="ativoFalse" value="0" ${entity.ativo ? '' : 'checked'}> Inativo
        </label>
    </div>
    <div class="form-group pull-right">
        <button type="submit" class="btn btn-primary">Salvar</button>
        <a href="${linkTo[UsuarioController].index}" class="btn btn-default">Voltar</a>
    </div>
</form>