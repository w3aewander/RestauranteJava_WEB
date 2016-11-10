/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.entidades;

import java.util.Calendar;

/**
 *
 * @author Wanderlei
 */
public class Funcionario extends Pessoa{

    private String ctps;
    private Cargo cargo;
    private Setor setor;
    private Calendar data_admissao, data_demissao;
    private Boolean deficiente_fisico;

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Calendar getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Calendar data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Calendar getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Calendar data_demissao) {
        this.data_demissao = data_demissao;
    }

    public Boolean getDeficiente_fisico() {
        return deficiente_fisico;
    }

    public void setDeficiente_fisico(Boolean deficiente_fisico) {
        this.deficiente_fisico = deficiente_fisico;
    }
   
    
    
    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
