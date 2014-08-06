package br.com.valdineireis.v4labs.dao.common;

import java.util.Collection;

import br.com.valdineireis.v4labs.exception.CommonException;
import br.com.valdineireis.v4labs.model.common.AbstractEntity;

/**
 *
 * @author valdineireis
 * @param <T> Classe
 */
public interface GenericDAO<T extends AbstractEntity> {
    
    /**
     * Retorna todos os objetos do banco de dados
     * @return 
     */
    Collection<T> listaTodos();

    /**
     * Busca um objeto pelo ID
     * @param id código de identificação do objeto no banco de dados
     * @return Objeto, caso ele exista
     */
    T buscarPorId(Long id);

    /**
     * Remove o objeto do banco de dados
     * @param entity 
     */
    void remove(T entity);

    /**
     * Adiciona um novo objeto no banco de dados
     * @param entity objeto a ser persistido
     * @throws CommonException 
     */
    void adiciona(T entity) throws CommonException;
    
    /**
     * Atualiza o objeto no banco de dados
     * @param entity 
     */
    void atualiza(T entity) throws CommonException;
}
