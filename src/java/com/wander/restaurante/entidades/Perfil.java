
package com.wander.restaurante.entidades;

import java.io.Serializable;

/**
 *
 * @author Wanderlei
 */
public class Perfil implements Serializable {

    private int id;
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
