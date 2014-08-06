package br.com.valdineireis.v4labs.helper;

import br.com.valdineireis.v4labs.model.Perfil;
import br.com.valdineireis.v4labs.model.Usuario;

/**
 *
 * @author Valdinei Reis (valdineimtz@gmail.com)
 */
public class UsuarioHelperTest {

    public static Usuario Novo(String nome, String login) {
        return Novo(0L, nome, login, true, null);
    }
    
    public static Usuario Novo(Long id, String nome, String login, boolean ativo, Perfil perfil) {
        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(login + "123");
        usuario.setAtivo(ativo);
        usuario.setPerfil(perfil);

        return usuario;
    }
}
