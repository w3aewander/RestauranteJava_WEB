package com.wander.restaurante.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author Wanderlei
 */
public class FluxoCaixa implements Serializable {
    
    private Long codigo;
    private Calendar created_at;
    private String tipo_movimento;
    private String motivo;
    private Double valor;
    private String responsavel;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
   
    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public String getTipo_movimento() {
        return tipo_movimento;
    }

    public void setTipo_movimento(String tipo_movimento) {
        this.tipo_movimento = tipo_movimento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
        final FluxoCaixa other = (FluxoCaixa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }


    

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "FluxoCaixa{" + "codigo=" + codigo + ", created_at=" + created_at + ", tipo_movimento=" + tipo_movimento + ", motivo=" + motivo + ", valor=" + valor + ", responsavel=" + responsavel + '}';
    }
    
}
