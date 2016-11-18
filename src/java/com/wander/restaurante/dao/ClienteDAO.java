/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Cliente;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wanderlei
 * @param <Cliente>
 */
public class ClienteDAO extends AbsDAO<Cliente> {

    /**
     *
     * @param t
     */
    @Override
    public void inserir(Cliente t) {
        StringBuilder sb = new StringBuilder();
        sb.append(" insert into clientes");
        sb.append(" ( nome,sexo,data_nasc,tipo_pessoa,cpf_cnpj,email,site,facebook,celular,fixo,tel_recado,ativo,observacao ) ");
        sb.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");

        try {
            pst = getConexao().prepareStatement(sb.toString(), pst.RETURN_GENERATED_KEYS);

            pst.setString(1, t.getNome());
            pst.setString(2, t.getSexo());
            pst.setTimestamp(3, new Timestamp(t.getData_nasc().getTimeInMillis()));
            pst.setString(4, t.getTipo_pessoa());
            pst.setString(5, t.getCpf_cnpj());
            pst.setString(6, t.getEmail());
            pst.setString(7, t.getSite());
            pst.setString(8, t.getFacebook());
            pst.setString(9, t.getCelular());
            pst.setString(10, t.getFixo());
            pst.setString(11, t.getTel_recado());
            pst.setBoolean(12, t.getAtivo());
            pst.setString(13, t.getObs());

            if (pst.executeUpdate() == 0) {
                throw new SQLException("Não foi possível incluir registro.");
            } else {
                
                rs = pst.getGeneratedKeys();

                if (rs.next()) {
                    t.setCodigo(rs.getLong(1));
                    StringBuilder sb_endereco = new StringBuilder();
                    sb_endereco.append("insert into enderecos_clientes ");
                    sb_endereco.append("( cliente_codigo, cep, logradouro,numero,lote,quadra,bairro,cidade,uf ) ");
                    sb_endereco.append(" values ( ?,?,?,?,?,?,?,?,? ) ");

                    pst = getConexao().prepareStatement(sb_endereco.toString(), pst.RETURN_GENERATED_KEYS);

                    pst.setLong(1, t.getCodigo());
                    pst.setString(2, t.getEndereco().getCep());
                    pst.setString(3, t.getEndereco().getLogradouro());
                    pst.setInt(4, t.getEndereco().getNumero());
                    pst.setString(5, t.getEndereco().getLote());
                    pst.setString(6, t.getEndereco().getQuadra());
                    pst.setString(7, t.getEndereco().getBairro());
                    pst.setString(8, t.getEndereco().getCidade());
                    pst.setString(9, t.getEndereco().getUf());

                    pst.executeUpdate();

                } else {
                    throw new SQLException("Não foi possível obter ID do cliente.");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void excluir(Cliente t) {

    }

    @Override
    public void atualizar(Cliente t) {

    }

    @Override
    public List<Cliente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente pesquisar(Long id) {
        return null;
    }

}
