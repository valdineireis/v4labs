package br.com.valdineireis.v4labs.dao;

import br.com.valdineireis.v4labs.dao.common.GenericDAO;
import br.com.valdineireis.v4labs.model.Usuario;

/**
 *
 * @author valdineireis
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

    /**
     * Synchronize the user data with the database. Any not saved modification
     * on user will be overwritten.
     *
     * @param usuario
     * @return
     */
    Usuario refresh(Usuario usuario);

    /**
     * Busca um usuário por login e senha
     *
     * @param login
     * @param password
     * @return localiza um usuário se ele é unico
     */
    Usuario busca(String login, String password);

    /**
     * Checks if there is already an user with given login.
     *
     * @param login
     * @return true if there exists a user
     */
    boolean contemUsuarioComLogin(String login);
    
    /**
     * Verificar se um Usuario tem determinada Permissão
     * @param entity
     * @param permissao
     * @return 
     */
    boolean isPermissionExist(Usuario entity, String permissao);

}
