package br.com.valdineireis.v4labs.dao;

import br.com.valdineireis.v4labs.model.Usuario;

import java.util.List;

/**
 *
 * @author valdineireis
 */
public interface UsuarioDAO {

    /**
     * Adiciona o usuário no banco de dados
     * @param usuario
     */
    void adiciona(Usuario usuario);

    /**
     * Atualiza o usuário no banco de dados
     * @param usuario
     */
    void atualiza(Usuario usuario);

    /**
     * Synchronize the user data with the database. Any not saved modification
     * on user will be overwritten.
     *
     * @param usuario
     * @return
     */
    Usuario refresh(Usuario usuario);

    /**
     * Retorna todos os usuários do banco de dados
     * @return 
     */
    List<Usuario> listaTodos();

    /**
     * Busca um usuário por login e senha
     *
     * @param login
     * @param password
     * @return localiza um usuário se ele é unico
     */
    Usuario busca(String login, String password);

    /**
     * Busca usuário pelo ID
     *
     * @param id código de identificação do objeto no banco de dados
     * @return localiza o usuário, caso ele exista
     */
    Usuario buscarPorId(long id);

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
