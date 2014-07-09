package br.com.valdineireis.v4labs.model;

import br.com.valdineireis.v4labs.model.common.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valdineireis
 */
@Entity
@Table(name = "grupo_permissao")
public class GrupoPermissao extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(length = 80, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "grupo")
    private List<Permissao> permissoes;

    public GrupoPermissao() {
        this.permissoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
