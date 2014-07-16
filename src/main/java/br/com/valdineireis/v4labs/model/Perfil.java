package br.com.valdineireis.v4labs.model;

import br.com.valdineireis.v4labs.model.common.AbstractEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "perfis_permissoes", 
            joinColumns = @JoinColumn(name = "perfil_id"), 
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private Set<Permissao> permissoes;
    
    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;

    public Perfil() {
        this.permissoes = new HashSet<>();
        this.usuarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
