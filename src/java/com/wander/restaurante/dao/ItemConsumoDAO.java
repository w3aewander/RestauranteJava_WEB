/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import static com.wander.restaurante.dao.AbsDAO.stm;
import com.wander.restaurante.entidades.ItemConsumo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wanderlei
 */
public class ItemConsumoDAO extends AbsDAO<ItemConsumo> {

    private static List<Object[]> itensConsumo ;
    
    public ItemConsumoDAO(){
        itensConsumo = new ArrayList<>();
    }

    public  List<Object[]> listarItensComanda() throws SQLException {
        
        itensConsumo = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append(" select i.comanda_codigo comanda, p.descricao produto, i.qtde qtde, i.valor_unitario valor_unitario,i.valor_total valor_total, date_format(i.updated_at,'%d-%m-%Y %T')  horario ");
        sb.append(" from comandas c, itensconsumo i, produtos p ");
        sb.append(" where c.codigo = i.comanda_codigo ");
        sb.append(" and i.produto_codigo = p.codigo ");

        stm = getConexao().createStatement();
        rs = stm.executeQuery(sb.toString());
        
        preencherListaItens(rs);
        
        return itensConsumo;
    }

    
    public  List<Object[]> listarItensComanda(Long comanda_codigo) throws SQLException {
        
         itensConsumo = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append(" select i.comanda_codigo comanda, p.descricao produto, i.qtde qtde, i.valor_unitario valor_unitario,i.valor_total valor_total, date_format(i.updated_at,'%d-%m-%Y %T')  horario ");
        sb.append(" from comandas c, itensconsumo i, produtos p ");
        sb.append(" where c.codigo = i.comanda_codigo ");
        sb.append(" and i.produto_codigo = p.codigo and i.comanda_codigo = ? " );

        pst = getConexao().prepareStatement(sb.toString());
        pst.setLong(1, comanda_codigo);
        
        rs = pst.executeQuery();

        preencherListaItens(rs);
        
        return itensConsumo;
    }
    
    private void preencherListaItens(ResultSet rs) throws SQLException{
              
        while (rs.next()) {
            
            Object[] itens = new Object[]{
                rs.getLong("comanda"),
                rs.getString("produto"),
                rs.getDouble("qtde"),
                rs.getDouble("valor_unitario"),
                rs.getDouble("valor_total"),
                rs.getString("horario")
            };
    
            itensConsumo.add(itens);
   
        }

    }
    @Override
    public List<ItemConsumo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemConsumo pesquisar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
