package br.com.valdineireis.v4labs.dao;

import br.com.valdineireis.v4labs.model.Usuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.valdineireis.v4labs.dao.common.JPAGenericDAO;

/**
 * @author valdineireis
 */
@Stateless
public class JPAUsuarioDAO extends JPAGenericDAO<Usuario> implements UsuarioDAO {

    @Deprecated // CDI eyes only
    public JPAUsuarioDAO() {
        this(null);
    }

    public JPAUsuarioDAO(EntityManager em) {
        super(em);
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

    @Override
    public boolean isPermissionExist(Usuario entity, String permissao) {
        /*
         select perfil.id from Perfil perfil inner join PerfilPermissao pp 
         on (perfil.id = pp.idPerfil) inner join Permissao permissao 
         on (pp.idPermissao = permissao.id) 
         where perfil.id = :id and permissao.chave like :permissao
         */
        try {
            Query query = em.createQuery("select usuario.id from " + Usuario.class.getName() + " usuario join usuario.perfil join usuario.perfil.permissoes permissoes where usuario.id = :id and :permissao in permissoes.chave");
            query.setParameter("permissao", permissao);
            query.setParameter("id", entity.getId());
            return (query.getSingleResult() != null);
        } catch (NoResultException e) {
            return false;
        }
    }

    private Session getSession() {
        return em.unwrap(Session.class);
    }
}
