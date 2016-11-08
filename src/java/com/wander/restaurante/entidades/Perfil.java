
package com.wander.restaurante.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Wanderlei
 */
@Entity
@Table(name = "perfis")
public class Perfil implements Serializable {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "codigo", nullable=false)
    private int id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
