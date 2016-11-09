/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.entidades;

import java.io.Serializable;

/**
 *
 * @author Wanderlei
 */
public class Unidade implements Serializable {

    private Long id;
    private String nome;

    public Unidade() {
    }

    public Unidade (Long id){
        this.id = id;
    }
    public Unidade(String nome) {
        this.nome = nome;
    }

    public Unidade(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
