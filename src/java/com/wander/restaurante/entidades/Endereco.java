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
public class Endereco implements Serializable {

    private int Id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String lote, quadra;
    private String bairro, cidade, uf;

    public Endereco() {
    }

    public Endereco(int id) {
        this.Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public  int getNumero() {
        return numero;
    }
    
    public void setNumero(int  n){
        this.numero = n;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.Id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        return this.Id == other.Id;
    }

    @Override
    public String toString() {
        return "Endereco: " + "Id=" + Id + ", logradouro=" + logradouro + ", cep=" + cep + ", lote=" + lote + ", quadra=" + quadra + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf;
    }

}
