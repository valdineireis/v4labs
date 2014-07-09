package br.com.valdineireis.v4labs.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.valdineireis.v4labs.dao.IUsuarioDAO;
import br.com.valdineireis.v4labs.model.Usuario;
import br.com.valdineireis.v4labs.model.validation.LoginAvailable;
import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author valdineireis
 */
@Controller
public class UsuarioController {
    
    @Inject private IUsuarioDAO dao;
    @Inject private Result result;
    @Inject private Validator validator;
    
    @Get("/usuarios")
    public void index() {
        result.include("entityList", dao.listaTodos());
    }
    
    public void novo() {
    }

    @Post("/usuario/salva")
    public void adiciona(@Valid @LoginAvailable Usuario usuario) {
        validator.onErrorUsePageOf(this).novo();
        
        dao.adiciona(usuario);
        
        result.redirectTo(this).index();
    }
    
    @Get("/usuario/{id}")
    public void edita(long id) {
        result.include("entity", dao.buscarPorId(id));
    }
    
    @Put("/usuario/salva")
    public void atualiza(Usuario entity) {
        dao.atualiza(entity);
        result.redirectTo(this).index();
    }
}
