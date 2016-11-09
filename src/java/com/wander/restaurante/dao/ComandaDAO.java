/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Comanda;
import com.wander.restaurante.entidades.ItemConsumo;
import com.wander.restaurante.entidades.Produto;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wanderlei
 */
public class ComandaDAO extends AbsDAO<Comanda> {

    private Comanda comanda;
    private static List<ItemConsumo> itensConsumo;

    public ComandaDAO() {
        this.comanda = new Comanda();
    }

    /**
     * Adicionar um novo item de consumo na lista
     *
     * @param p
     * @param qtde
     */
    public void addItem(Produto p, Double qtde) {

        comanda.getItensConsumo().add(new ItemConsumo(p, qtde, Calendar.getInstance(), Calendar.getInstance()));
    }

    /**
     * Exibe a lista de itens de consumo da comanda.
     *
     * @return
     */
    public List<ItemConsumo> getItensConsumo() {
        return itensConsumo;
    }

    /**
     * Remove um item de consumo da lista de itens
     *
     * @param index
     */
    public void removerItemConsumo(Integer index) {
        itensConsumo.remove(index);
    }

    @Override
    public void excluir(Comanda t) {
        super.excluir(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Comanda t) {
        try {
            comanda = t;
            StringBuilder sb = new StringBuilder();
            sb.append(" insert into comandas ( status,  created_at, updated_at  ) ");
            sb.append(" values ( ?,?,?) ");

            pst = getConexao().prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, comanda.getStatus());
            pst.setTimestamp(2, com.wander.restaurante.util.Utils.convertForward(Calendar.getInstance()));
            pst.setTimestamp(3, com.wander.restaurante.util.Utils.convertForward(Calendar.getInstance()));

            pst.executeUpdate();
            rs = pst.getGeneratedKeys();

            while (rs.next()) {
                comanda.setId(rs.getLong("GENERATED_KEY"));
            }

            /**
             * ordem de inclusão na tabela itensconsumo comanda_codigo,
             * produto_codigo, qtde, created_at, updated_at
             */
            String sql = "insert into itensconsumo ( comanda_codigo,produto_codigo,qtde,valor_unitario,valor_total,created_at,updated_at ) "
                    + " values ( ?,?,?,?,?,?,? ) ";

            comanda.getItensConsumo().stream().forEach((item) -> {
                try {

                    Double valorUnitario = new ProdutoDAO().pesquisar(item.getProduto().getId()).getValorUnitario();

                    pst = getConexao().prepareStatement(sql);

                    pst.setLong(1, comanda.getId());
                    pst.setLong(2, item.getProduto().getId());
                    pst.setDouble(3, item.getQtde());
                    pst.setDouble(4, valorUnitario);
                    pst.setDouble(5, valorUnitario * item.getQtde());

                    pst.setTimestamp(6, new Timestamp(item.getCreated_at().getTimeInMillis()));
                    pst.setTimestamp(7, new Timestamp(item.getUpdated_at().getTimeInMillis()));

                    pst.executeUpdate();

                } catch (SQLException ex) {
                    Logger.getLogger(ComandaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(ComandaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  List<Object[]> itensComanda() throws SQLException{
        return new ItemConsumoDAO().listarItensComanda();
    }
    public  List<Object[]> itensComanda(Long comanda_codigo) throws SQLException{
        return new ItemConsumoDAO().listarItensComanda(comanda_codigo);
    }
    
    @Override
    public List<Comanda> listar() {
            return null;
    }

    @Override
    public Comanda pesquisar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
