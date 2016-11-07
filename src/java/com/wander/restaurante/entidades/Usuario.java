package com.wander.restaurante.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Wanderlei
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo")
    private Long id;
    @NotNull
    @Size(min = 1, max = 50)
    private String nome;

    @Column(name = "email")
    private String email;

    @Size(max = 20)
    @Column(name = "login")
    private String login;

    @Size(max = 255)
    @Column(name = "senha")
    private String senha;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date created_at;

    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @Size(max = 20)
    private Perfil perfil ;

    @OneToOne
    private Endereco endereco;

    public Usuario() {
        this.endereco = new Endereco();
        this.perfil = new Perfil();
        this.created_at = Calendar.getInstance().getTime();
        this.updated_at = this.created_at;
    }

    public Usuario(Long codigo) {
        this.id = codigo;
        this.endereco = new Endereco();
        this.perfil = new Perfil();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "entidades.Usuarios[ codigo=" + id + " ]";
    }

    public Long getCodigo() {
        return id;
    }

    public void setCodigo(Long codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @OneToOne
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
