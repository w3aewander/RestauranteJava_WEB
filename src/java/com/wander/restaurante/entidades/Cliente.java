package com.wander.restaurante.entidades;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Wanderlei
 */
public class Cliente extends Pessoa implements Serializable {

    protected Calendar data_nasc;
    protected String sexo;
    protected String estadoCivil;
    protected Boolean receberPromocoes;
    
    public Calendar getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Calendar data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Boolean getReceberPromocoes() {
        return receberPromocoes;
    }

    public void setReceberPromocoes(Boolean receberPromocoes) {
        this.receberPromocoes = receberPromocoes;
    }
    
}
