package br.com.valdineireis.v4labs.controller;

import static java.util.Arrays.asList;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.valdineireis.v4labs.dao.UsuarioDAO;
import br.com.valdineireis.v4labs.model.Usuario;
import br.com.valdineireis.v4labs.model.validation.LoginAvailable;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.valdineireis.v4labs.dao.PerfilDAO;
import br.com.valdineireis.v4labs.exception.CommonException;
import br.com.valdineireis.v4labs.factory.MessageFactory;

/**
 * @author valdineireis
 */
@Controller
public class UsuarioController {
    
    @Inject private UsuarioDAO dao;
    @Inject private PerfilDAO perfilDAO;
    @Inject private Result result;
    @Inject private Validator validator;
    @Inject private MessageFactory messageFactory;
    
    @Get("/usuarios")
    public void index() {
        result.include("entityList", dao.listaTodos());
    }
    
    public void novo(Usuario usuario) {
        result.include("usuario", usuario)
              .include("perfis", perfilDAO.listaTodos());
    }

    @Post("/usuario/salva")
    public void adiciona(@NotNull @Valid @LoginAvailable Usuario entity) {
        validator.onErrorRedirectTo(this).novo(entity);
        
        try {
            dao.adiciona(entity);
            result.include("success", asList(messageFactory.build("Usuario", "cadastro.sucesso")));
            result.redirectTo(this).index();
        } catch (CommonException ex) {
            result.include("errors", asList(messageFactory.build("Usuario", ex.getMessage())));
            result.redirectTo(this).novo(entity);
        }
    }
    
    @Get("/usuario/{id}")
    public void edita(long id) {
        result.include("entity", dao.buscarPorId(id))
              .include("perfis", perfilDAO.listaTodos());
    }
    
    @Put("/usuario/salva")
    public void atualiza(Usuario entity) {
        // Busca as informacoes cadastradas anteriormente
        Usuario usuarioAntigo = dao.buscarPorId(entity.getId());
        
        // Adiciona as informacoes que nao devem ser atualizadas no objeto atual
        entity.setLogin(usuarioAntigo.getLogin());
        entity.setSenha(usuarioAntigo.getSenha());
        entity.setSalt(usuarioAntigo.getSalt());
        
        // Efetua a validacao
        validator.validate(entity);
        validator.onErrorRedirectTo(this).edita(entity.getId());
        
        try {
            dao.atualiza(entity);
            result.include("success", asList(messageFactory.build("Usuario", "atualizacao.sucesso")));
            result.redirectTo(this).index();
        } catch (CommonException ex) {
            result.include("errors", asList(messageFactory.build("Usuario", ex.getMessage())));
            result.redirectTo(this).novo(entity);
        }
    }
}
