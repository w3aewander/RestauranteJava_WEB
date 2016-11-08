package com.wander.restaurante.dao;

import com.wander.restaurante.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Wanderlei
 * @param <T>
 */
public abstract class AbsDAO<T> extends Conexao implements IDAO<T> {

    protected static Statement stm = null;
    protected static PreparedStatement pst  = null;
    protected static ResultSet rs = null;
    
    public AbsDAO() {

    }

    @Override
    public void inserir(T t) {     
    }
    
    @Override
    public void excluir(T t) {
    }

    @Override
    public void atualizar(T t) {
    }

}
