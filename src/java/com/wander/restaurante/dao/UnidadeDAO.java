/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Wanderlei
 * @param <Unidade>
 */
public class UnidadeDAO<Unidade>  extends AbsDAO<Unidade>{

    @Override
    public List<Unidade> listar() {
       this.session.beginTransaction();
       List<Unidade> listaUnidades = this.session.createQuery("From Unidade").list();
       
       for ( Iterator it = listaUnidades.iterator();it.hasNext();){
           Unidade unidade = (Unidade) it.next();
       }
       
       return listaUnidades;
    }

    @Override
    public Unidade pesquisar(Unidade t) {
        return null;
    }

    
}
