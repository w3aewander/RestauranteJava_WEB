/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Produto;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wanderlei
 */
public class ProdutoDAO extends AbsDAO<Produto> {

    private Produto produto = null;
    List<Produto> listaProdutos = null;

    public ProdutoDAO() {
        this.produto = new Produto();
        this.listaProdutos = new ArrayList<>();
    }

    @Override
    public void inserir(Produto t) {
        try {
            produto = t;
            
            StringBuilder sb = new StringBuilder();
            sb.append("insert into produtos ( descricao,unidade_codigo,valor_unitario,created_at,updated_at ) " );
            sb.append(" value ( ?,?,?,?, ?  ) ");
            
            pst = getConexao().prepareStatement(sb.toString());
            pst.setString(1, produto.getDescricao());
            pst.setLong(2, produto.getUnidade().getId());
            pst.setDouble(3, produto.getValorUnitario());
            
            pst.setTimestamp(4, new java.sql.Timestamp(produto.getCreated_at().getTimeInMillis()));
            pst.setTimestamp(5, new java.sql.Timestamp(produto.getUpdated_at().getTimeInMillis()));
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public void atualizar(Produto t) {
        try {
            produto = t;
            
            StringBuilder sb = new StringBuilder();
            sb.append(" update  produtos  set descricao = ?, unidade_codigo = ? , valor_unitario = ?, created_at = ? , updated_at = ?  where codigo = ? " );
            
            pst = getConexao().prepareStatement(sb.toString());
            pst.setString(1, produto.getDescricao());
            pst.setLong(2, produto.getUnidade().getId());
            pst.setDouble(3, produto.getValorUnitario());
            pst.setDate(4, new java.sql.Date(produto.getCreated_at().getTimeInMillis()));
            pst.setTimestamp(5, new java.sql.Timestamp(produto.getUpdated_at().getTimeInMillis()));
            pst.setLong(6,  produto.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void excluir(Produto t) {
     try {
            produto = t;
            
            StringBuilder sb = new StringBuilder();
            sb.append(" delete from produtos  where codigo = ? " );
            
            pst = getConexao().prepareStatement(sb.toString());
            pst.setLong(1,  produto.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
 
    @Override
    public List<Produto> listar() {
        try {
            stm = getConexao().createStatement();
            rs = stm.executeQuery("select * from produtos");

           Calendar cal = Calendar.getInstance();
           
           while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                produto.getUnidade().setId(rs.getLong("unidade_codigo"));
                produto.setValorUnitario(rs.getDouble("valor_unitario"));
                produto.setCreated_at( com.wander.restaurante.util.Utils.convertReverse(rs.getTimestamp("created_at")) ) ;
                produto.setUpdated_at(  com.wander.restaurante.util.Utils.convertReverse(rs.getTimestamp("created_at"))  );

                listaProdutos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProdutos;
    }

    @Override
    public Produto pesquisar(Long id) {

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select * from produtos where codigo = ? ");
            pst = getConexao().prepareStatement(sb.toString());
            pst.setLong(1, id);
            rs = pst.executeQuery();

            rs.first();

            produto.setId(rs.getLong("codigo"));
            produto.setDescricao(rs.getString("descricao"));
            produto.getUnidade().setId(rs.getLong("unidade_codigo"));
            produto.setValorUnitario(rs.getDouble("valor_unitario"));
            produto.setCreated_at(Calendar.getInstance());
            produto.setUpdated_at(Calendar.getInstance());

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return produto;
    }

}