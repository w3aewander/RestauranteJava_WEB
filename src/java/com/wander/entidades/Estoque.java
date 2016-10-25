/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.entidades;

/**
 *
 * @author wanderlei
 */
public class Estoque {

        private Produto produto;
        private Integer qtde_atual;
        private Integer qtde_minima;
        private Integer qtde_maxima;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtde_atual() {
        return qtde_atual;
    }

    public void setQtde_atual(Integer qtde_atual) {
        this.qtde_atual = qtde_atual;
    }

    public Integer getQtde_minima() {
        return qtde_minima;
    }

    public void setQtde_minima(Integer qtde_minima) {
        this.qtde_minima = qtde_minima;
    }

    public Integer getQtde_maxima() {
        return qtde_maxima;
    }

    public void setQtde_maxima(Integer qtde_maxima) {
        this.qtde_maxima = qtde_maxima;
    }
}
