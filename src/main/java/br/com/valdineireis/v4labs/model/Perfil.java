package br.com.valdineireis.v4labs.model;

import br.com.valdineireis.v4labs.model.common.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author valdineireis
 */
@Entity
@Table(name = "perfil")
public class Perfil extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(length = 80, nullable = false)
    private String nome;
    
    @ManyToMany
    @JoinTable(name = "perfis_permissoes")
    private List<Permissao> permissoes;
    
    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;

    public Perfil() {
        this.permissoes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
