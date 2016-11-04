/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Wanderlei
 * @param <T>
 */
public abstract class AbsDAO<T> implements IDAO<T> {

    protected Session session;
    protected Transaction trans;
    
    public AbsDAO() {

        session = HibernateUtil.getSessionFactory().openSession();
        trans = session.getTransaction();
                
    }

    @Override
    public void inserir(T t) {      
         
         trans.begin();
         session.save(t);
         trans.commit();
    }
    
    @Override
    public void excluir(T t) {
      trans.begin();
      session.delete(t);
      trans.commit();      
    }

    @Override
    public void atualizar(T t) {
      trans.begin();
      session.merge(t);
      trans.commit();      
    }

}
