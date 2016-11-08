/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Wanderlei
 */
public class UsuarioDAO extends AbsDAO<Usuario> {

    private Usuario usuario = new Usuario();
    
    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario pesquisar(Long id) {        
        return null;
    }
    
}
