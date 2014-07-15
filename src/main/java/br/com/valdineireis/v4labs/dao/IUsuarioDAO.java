package br.com.valdineireis.v4labs.dao;

import br.com.valdineireis.v4labs.model.Usuario;
import java.util.List;
import java.util.Set;

/**
 *
 * @author valdineireis
 */
public interface IUsuarioDAO {

    /**
     * Adiciona o usuário no banco de dados
     */
    void adiciona(Usuario usuario);

    /**
     * Atualiza o usuário no banco de dados
     */
    void atualiza(Usuario usuario);

    /**
     * Synchronize the user data with the database. Any not saved modification
     * on user will be overwritten.
     *
     * @return
     */
    Usuario refresh(Usuario usuario);

    /**
     * Retorna todos os usuários do banco de dados
     */
    List<Usuario> listaTodos();

    /**
     * Busca um usuário por login e senha
     *
     * @return localiza um usuário se ele é unico
     * @throws HibernateException, if there are more than one user
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
     * @return true if there exists a user
     */
    boolean contemUsuarioComLogin(String login);
    
    boolean isPermissionExist(Usuario entity, String permissao);
    
    
    Usuario selecionarUsuarioByUsername(String username);
    
    Set<String> listarPerfilsByUsername(String username);
    
    Set<String> listarPermissoesByPerfil(String role);

}
