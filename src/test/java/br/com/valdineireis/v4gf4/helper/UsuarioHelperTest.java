package br.com.valdineireis.v4gf4.helper;

import br.com.valdineireis.v4gf4.model.Usuario;

/**
 *
 * @author Valdinei Reis (valdineimtz@gmail.com)
 */
public class UsuarioHelperTest {

    public static Usuario Novo(String nome, String login) {
        return Novo(0L, nome, login, true);
    }
    
    public static Usuario Novo(Long id, String nome, String login, boolean ativo) {
        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(login + id);
        usuario.setAtivo(ativo);

        return usuario;
    }
}
