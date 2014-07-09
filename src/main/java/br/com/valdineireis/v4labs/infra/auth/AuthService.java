package br.com.valdineireis.v4labs.infra.auth;

import br.com.caelum.vraptor.security.Permission;
import br.com.caelum.vraptor.security.User;
import br.com.valdineireis.v4labs.dao.IUsuarioDAO;
import br.com.valdineireis.v4labs.model.Usuario;
import java.util.Set;
import javax.inject.Inject;

public class AuthService implements Permission {

    @Inject IUsuarioDAO usuarioDAO;
    
    @Override
    public User getUserByUsername(String username) {
        Usuario usuario = usuarioDAO.selecionarUsuarioByUsername(username);
        return new User(usuario.getLogin(), usuario.getSenha());
    }

    @Override
    public Set<String> getRolesByUser(String username) {
        return usuarioDAO.listarPerfilsByUsername(username);
    }

    @Override
    public Set<String> getPermissionsByRole(String role) {
        return usuarioDAO.listarPermissoesByPerfil(role);
    }
    
}
