package br.com.valdineireis.v4labs.infra.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.valdineireis.v4labs.model.Usuario;

@SessionScoped
@Named
public class UserSession implements Serializable {
    
    private static final long serialVersionUID = 1640106041603610422L;
    
    private Usuario usuario;

    public Usuario getUser() {
        return usuario;
    }

    public void login(Usuario user) {
        this.usuario = user;
    }

    public void logout() {
        this.usuario = null;
    }
}
