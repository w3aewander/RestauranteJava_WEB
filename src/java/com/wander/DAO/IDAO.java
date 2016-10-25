/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.DAO;

/**
 *
 * @author wanderlei
 */
interface IDAO<O> {
    public void inserir(O o);
    public void excluir(O o);
    public void atualizar(O o);
    public void pesquisar(O o);
    public void listar(O o);    
}
