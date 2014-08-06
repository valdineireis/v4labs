package br.com.valdineireis.v4labs.controller;

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

import br.com.valdineireis.v4labs.exception.CommonException;
import br.com.valdineireis.v4labs.factory.MessageFactory;

/**
 * @author valdineireis
 */
@Controller
public class UsuarioController {
    
    @Inject private UsuarioDAO dao;
    @Inject private Result result;
    @Inject private Validator validator;
    @Inject private MessageFactory messageFactory;
    
    @Get("/usuarios")
    public void index() {
        result.include("entityList", dao.listaTodos());
    }
    
    public void novo(Usuario usuario) {
        result.include("usuario", usuario);
    }

    @Post("/usuario/salva")
    public void adiciona(@Valid @LoginAvailable Usuario usuario) {
        validator.onErrorUsePageOf(this).novo(usuario);
        
        try {
            dao.adiciona(usuario);
            result.include("success", messageFactory.build("Usuario", "cadastro.sucesso"));
        } catch (CommonException ex) {
            result.include("errors", messageFactory.build("Usuario", "cadastro.sucesso"));
            result.redirectTo(this).novo(usuario);
        }
        
        result.redirectTo(this).index();
    }
    
    @Get("/usuario/{id}")
    public void edita(long id) {
        result.include("entity", dao.buscarPorId(id));
    }
    
    @Put("/usuario/salva")
    public void atualiza(@Valid Usuario entity) {
        validator.onErrorUsePageOf(this).edita(entity.getId());
        
        dao.atualiza(entity);
        result.redirectTo(this).index();
    }
}
