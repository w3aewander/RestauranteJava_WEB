/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Unidade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wanderlei
 */
public class UnidadeDAO extends AbsDAO<Unidade> {

    Unidade unidade = null;
    List<Unidade> listaUnidades = null;

    public UnidadeDAO() {
    
       this.unidade = new Unidade();
    }

    
    @Override
    public void inserir(Unidade t) {

        try {
            this.unidade = t;
            
            StringBuilder sb = new StringBuilder();
            sb.append("insert into unidades (nome ) ");
            sb.append(" values ( ? ) ");
            
            pst = getConexao().prepareStatement(sb.toString());
            pst.setString(1, this.unidade.getNome());
            
            pst.executeUpdate();
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Unidade t) {

        try {
            this.unidade = t;
            
            StringBuilder sb = new StringBuilder();
            sb.append("update unidades set  nome = ?  ");
            sb.append(" where codigo  =  ?   ");
            
            pst = getConexao().prepareStatement(sb.toString());
            pst.setString(1, this.unidade.getNome());
            pst.setLong(2, this.unidade.getId());
            
            pst.executeUpdate();
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Unidade t) {

        try {
            this.unidade = t;
            StringBuilder sb = new StringBuilder();
            sb.append("delete from unidades where codigo = ?  ");
            
            pst = getConexao().prepareStatement(sb.toString());
            pst.setLong(1, this.unidade.getId());
            
            pst.executeUpdate();
            
            sb = null;
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    
    
    @Override
    public List<Unidade> listar() {

        try {
            String sql = "select * from unidades";

            stm = getConexao().createStatement();
            rs = stm.executeQuery(sql);
            //rs.first();

            Unidade u ;
            listaUnidades = new ArrayList<>();

            while (rs.next()) {
                u = new Unidade();
                u.setId(rs.getLong("codigo"));
                u.setNome(rs.getString("nome"));
                listaUnidades.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaUnidades;
    }

    @Override
    public Unidade pesquisar(Long id) {

        try {
            String sql = "select * from unidades u where u.codigo = ?";
            pst = getConexao().prepareStatement(sql);
            pst.setLong(1, id);

            rs = pst.executeQuery();

            rs.first();

            unidade = new Unidade(rs.getLong("codigo"), rs.getString("nome"));

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidade;
    }

}
