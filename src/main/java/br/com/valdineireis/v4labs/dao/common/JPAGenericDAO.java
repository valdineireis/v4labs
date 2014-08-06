package br.com.valdineireis.v4labs.dao.common;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.valdineireis.v4labs.exception.CommonException;
import br.com.valdineireis.v4labs.model.Usuario;
import br.com.valdineireis.v4labs.model.common.AbstractEntity;

/**
 *
 * @author Valdineireis
 * @param <T>
 */
public abstract class JPAGenericDAO<T extends AbstractEntity> implements GenericDAO<T> {

    /**
     * No arquivo persistence.xml contém 2 persistence unit, um para ambiente de
     * produção, e outro para testes. Aqui devemos selecionar o de produção que
     * é o default.
     */
    @PersistenceContext(unitName = "default")
    protected final EntityManager em;
    
    private final Class<T> clazz;

    protected JPAGenericDAO(EntityManager em) {
        this.em = em;

        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        this.clazz = clazz;
    }
    
    @Deprecated // CDI eyes only
    public JPAGenericDAO() {
        this(null);
    }

    @Override
    public Collection<T> listaTodos() {
        return em.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public T buscarPorId(Long id) {
        return em.find(clazz, id);
    }

    @Override
    public void remove(T entity) {
        em.remove(em.getReference(clazz, entity.getId()));
    }

    @Override
    public void adiciona(T entity) throws CommonException {
        em.persist(entity);
    }

    @Override
    public void atualiza(T entity) {
        em.merge(entity);
    }

}
