package br.com.valdineireis.v4labs.dao;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.com.valdineireis.v4labs.dao.common.JPAGenericDAO;
import br.com.valdineireis.v4labs.model.Perfil;

/**
 * @author valdineireis
 */
@Stateless
public class JPAPerfilDAO extends JPAGenericDAO<Perfil> implements PerfilDAO {

    @Deprecated // CDI eyes only
    public JPAPerfilDAO() {
        this(null);
    }

    public JPAPerfilDAO(EntityManager em) {
        super(em);
    }

    @Override
    public Collection<Perfil> listaTodos() {
        return em.createQuery("select p from " + Perfil.class.getName() + " p order by p.nome").getResultList();
    }
}
