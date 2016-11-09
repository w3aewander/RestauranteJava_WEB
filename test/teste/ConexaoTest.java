/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Wanderlei
 */
public class ConexaoTest {
    
    public ConexaoTest() {
    }
    
    @Test
    public void shouldBeReturnAConnectionTest() throws SQLException{
        System.out.println ("Conexao: " + Conexao.getConexao() );
        Assert.assertNotNull("Nulo", Conexao.getConexao());
        Statement stm = Conexao.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("select * from perfis");
        rs.first();
        
        while(rs.next()){
            System.out.println(rs.getString("nome"));
        }
        stm.close();
        rs.close();
    }
}
