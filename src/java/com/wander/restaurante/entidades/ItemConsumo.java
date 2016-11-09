/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.entidades;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Wanderlei
 */
public class ItemConsumo {

    private Produto produto;
    private Double qtde;
    private Calendar created_at;
    private Calendar updated_at;
    private List<Object[]> itensConsumo;

    public List<Object[]> getItensConsumo() {
        return itensConsumo;
    }

    public void setItensConsumo(List<Object[]> itensConsumo) {
        this.itensConsumo = itensConsumo;
    }

    public ItemConsumo(Produto produto, Double qtde) {
        this.produto = produto;
        this.qtde = qtde;
        this.created_at = Calendar.getInstance();
        this.updated_at = Calendar.getInstance();
    }

    public ItemConsumo(Produto produto, Double qtde, Calendar created_at, Calendar updated_at) {
        this.produto = produto;
        this.qtde = qtde;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQtde() {
        return qtde;
    }

    public void setQtde(Double qtde) {
        this.qtde = qtde;
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

    @Override
    public String toString() {
        return "ItemConsumo{" + "produto=" + produto + ", qtde=" + qtde + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }

}
