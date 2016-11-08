/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Produto;
import java.util.List;


/**
 *
 * @author Wanderlei
 */
public class ProdutoDAO extends AbsDAO<Produto> {

    @Override
    public List<Produto> listar() {
        List<Produto> listaProdutos = null;
        return listaProdutos;
    }

    @Override
    public Produto pesquisar(Long id) {
        
        Produto produto = null;
        return produto;

    }

}
