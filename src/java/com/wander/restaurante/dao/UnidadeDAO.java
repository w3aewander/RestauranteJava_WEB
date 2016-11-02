/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Unidade;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Wanderlei
 * @param <Unidade>
 */
public class UnidadeDAO  extends AbsDAO<Unidade>{

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
    public Unidade pesquisar(Long id) {
     
       Criteria crit = this.session.createCriteria(Unidade.class);
       crit.add(Restrictions.eq("id",id));
       return (Unidade) crit.uniqueResult();
    }

    
}
