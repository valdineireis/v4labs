package br.com.valdineireis.v4labs.model;

import br.com.valdineireis.v4labs.model.common.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valdineireis
 */
@Entity
@Table(name = "permissao")
public class Permissao extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(unique = true, length = 100)
    private String chave;
    
    private String descricao;
    
    @ManyToOne
    private GrupoPermissao grupo;
    
    @ManyToMany(mappedBy = "permissoes")
    private Set<Perfil> perfis;

    public Permissao() {
        this.perfis = new HashSet<>();
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public GrupoPermissao getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPermissao grupo) {
        this.grupo = grupo;
    }
}
