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
   
    public AbsDAO() {

        session = HibernateUtil.getSessionFactory().openSession();
        
    }

    @Override
    public void inserir(T t) {      
       session.beginTransaction();
       session.save(t);
       session.getTransaction().commit();
    }
    
    @Override
    public void excluir(T t) {
      session.beginTransaction();
      session.delete(t);
      session.getTransaction().commit();      
    }

    @Override
    public void atualizar(T t) {
      session.beginTransaction();
      session.merge(t);
      session.getTransaction().commit();      
    }

}
