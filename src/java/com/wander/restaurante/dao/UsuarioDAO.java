/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Wanderlei
 */
public class UsuarioDAO extends AbsDAO<Usuario> {

    @Override
    public List<Usuario> listar() {
        return this.session.createQuery("From Usuario").list();
    }

    @Override
    public Usuario pesquisar(Long id) {
        this.trans.begin();
        Criteria criteria = this.session.createCriteria(Usuario.class);
        return (Usuario) criteria.add(Restrictions.eq("id",id));
    }
    
}
