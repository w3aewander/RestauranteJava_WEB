
package com.wander.restaurante.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Wanderlei
 */
public class Fiado implements Serializable {
     
    private Long cliente_codigo;
    private String descricao;
    private Calendar data_prevista;
    private Calendar data_pagto;
    private Double valor;
    private String obs;
    private Calendar created_at;
    private Calendar updated_at;

    public Long getCliente_codigo() {
        return cliente_codigo;
    }

    public void setCliente_codigo(Long cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
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

    public Calendar getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(Calendar data_prevista) {
        this.data_prevista = data_prevista;
    }

    public Calendar getData_pagto() {
        return data_pagto;
    }

    public void setData_pagto(Calendar data_pagto) {
        this.data_pagto = data_pagto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.cliente_codigo);
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
        final Fiado other = (Fiado) obj;
        if (!Objects.equals(this.cliente_codigo, other.cliente_codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fiados{" + "cliente_codigo=" + cliente_codigo + ", created_at=" + created_at + ", updated_at=" + updated_at + ", data_prevista=" + data_prevista + ", data_pagto=" + data_pagto + ", descricao=" + descricao + ", obs=" + obs + ", valor=" + valor + '}';
    }
    
    
}
