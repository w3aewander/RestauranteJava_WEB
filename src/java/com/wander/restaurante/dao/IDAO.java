/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import java.util.List;

/**
 *
 * @author Wanderlei
 * @param <T>
 */
public interface IDAO<T> {
    public void inserir(T t);
    public void excluir(T t);
    public void atualizar(T t);
    public List<T> listar();
    public T pesquisar(Long id);
}
