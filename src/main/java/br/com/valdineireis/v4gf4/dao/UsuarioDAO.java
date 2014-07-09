package br.com.valdineireis.v4gf4.dao;

import br.com.valdineireis.v4gf4.model.Usuario;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

/**
 * @author valdineireis
 */
@Stateless
public class UsuarioDAO implements IUsuarioDAO {

    /**
     * No arquivo persistence.xml contém 2 persistence unit, um para ambiente de
     * produção, e outro para testes. Aqui devemos selecionar o de produção que
     * é o default.
     */
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @Deprecated // CDI eyes only
    public UsuarioDAO() {
    }

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void adiciona(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void atualiza(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public Usuario refresh(Usuario usuario) {
        getSession().refresh(usuario); // You still can use Hibernate Session
        return usuario;
    }

    @Override
    public Usuario busca(String login, String password) {
        try {
            Usuario user = em
                    .createQuery("select u from " + Usuario.class.getName()
                            + " u where u.ativo = true and u.login = :login and u.senha = :password", Usuario.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Usuario buscarPorId(long id) {
        try {
            Usuario user = em
                    .createQuery("select u from " + Usuario.class.getName()
                            + " u where u.id = :id", Usuario.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Usuario> listaTodos() {
        return em.createQuery("select u from " + Usuario.class.getName() + " u order by u.nome").getResultList();
    }

    @Override
    public boolean contemUsuarioComLogin(String login) {
        Long count = em
                .createQuery("select count(u) from " + Usuario.class.getName()
                        + " u where u.login = :login", Long.class)
                .setParameter("login", login)
                .getSingleResult();
        return count > 0;
    }

    private Session getSession() {
        return em.unwrap(Session.class);
    }

    public Usuario selecionarUsuarioByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<String> listarPerfilsByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<String> listarPermissoesByPerfil(String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
