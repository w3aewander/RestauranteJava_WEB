package com.wander.restaurante.entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Produto implements Serializable {

    private Long id;
    private String descricao;
    private Unidade unidade;
    private Double valorUnitario;
    private Calendar created_at;
    private Calendar updated_at;

    public Produto(Long id, String descricao, Unidade unidade, Double valorUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
        this.created_at = Calendar.getInstance();
        this.updated_at = this.created_at;
    }

    
    public Produto() {
        this.unidade = new Unidade();
        this.created_at = Calendar.getInstance();
        this.updated_at = this.created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public Calendar getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Calendar updated_at) {
        this.updated_at = updated_at;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", unidade=" + unidade + ", valorUnitario=" + valorUnitario + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

    
}
