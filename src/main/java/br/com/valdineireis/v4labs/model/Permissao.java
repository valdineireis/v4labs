package br.com.valdineireis.v4labs.model;

import br.com.valdineireis.v4labs.model.common.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
    @Column(unique = true)
    private String chave;
    
    private String descricao;
    
    @ManyToMany(mappedBy = "permissoes")
    private List<Perfil> perfis;

    public Permissao() {
        this.perfis = new ArrayList<>();
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

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }
}
