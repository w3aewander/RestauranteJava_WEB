package com.wander.restaurante.dao;

import com.wander.restaurante.entidades.Fiado;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wanderlei
 */
public class FiadoDAO extends AbsDAO<Fiado> {

    public FiadoDAO() {
    
        StringBuilder sb = new StringBuilder();
        
        sb.append( " create table if not exists fiados ("); 
        sb.append( " cliente_codigo bigint not null, ");
        sb.append( " descricao varchar(100),data_previta date not null,");
        sb.append( " data_pagto date,valor double,obs text(150),");
        sb.append( " created_at datetime,updated_at timestamp  default current_timestamp, ");
        sb.append( " constraint fk_fiado_cli_cod foreign key(cliente_codigo) references clientes(codigo) ) ");
        
        try {
            getConexao().createStatement().execute(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(FiadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Fiado> listar() {
        return null;
    }

    @Override
    public Fiado pesquisar(Long id) {
        return null;
    }
    
}