package br.com.valdineireis.v4labs.model;

import br.com.valdineireis.v4labs.model.common.AbstractEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * @author valdineireis
 */
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(length = 100)
    @Length(min = 3, max = 100)
    private String nome;

    @NotNull
    @Column(unique = true, length = 50)
    @Length(min = 3, max = 50)
    @Pattern(regexp = "[a-z0-9_]+", message = "{invalid_login}")
    private String login;

    @NotNull
    @Column(length = 250)
    @Length(min = 6, max = 20)
    private String senha;
    
    @Column(length = 100)
    private String salt;

    private boolean ativo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_perfis", 
            joinColumns = @JoinColumn(name = "usuario_id"), 
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private Set<Perfil> perfis;

    public Usuario() {
        this("", "", "", false);
    }

    public Usuario(String nome, String login, String senha, boolean ativo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.perfis = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}
