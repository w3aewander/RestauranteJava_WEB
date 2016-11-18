/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.ClienteDAO;
import com.wander.restaurante.entidades.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wanderlei
 */
public class ClienteTest {
    
    public ClienteTest() {
    }

@Test
public void testarSeVaiCriarUmNovoCliente(){
        try {
            Cliente cli = new Cliente();
            cli.setNome("Maria do Carmo");
            cli.setAtivo(true);
            cli.setCelular("2788989899");
            cli.setFixo("2733334444");
            cli.setCpf_cnpj("82899320734");
            cli.setTipo_pessoa("física");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date dataNasc = new java.sql.Date( sdf.parse("11/02/1965").getTime());
            System.out.println(String.valueOf(dataNasc));
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataNasc);
            cli.setData_nasc(cal);
            
            cli.setEstadoCivil("Casado");
            cli.setEmail("wander.silva@gmail.com");
            cli.setObs("Teste de inserção de dados.");
            
            cli.getEndereco().setCep("29032268");
            cli.getEndereco().setBairro("Santo Antonio");
            cli.getEndereco().setLogradouro("Trav xyz");
            cli.getEndereco().setNumero(1098);
            cli.getEndereco().setUf("ES");
            cli.getEndereco().setCidade("Vitória");
            
            
            ClienteDAO dao = new ClienteDAO();
            dao.inserir(cli);
            
        } catch (ParseException ex) {
            Logger.getLogger(ClienteTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
