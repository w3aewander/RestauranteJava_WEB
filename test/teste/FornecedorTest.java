/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.ClienteDAO;
import com.wander.restaurante.dao.FornecedorDAO;
import com.wander.restaurante.entidades.Cliente;
import com.wander.restaurante.entidades.Fornecedor;
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
public class FornecedorTest {

    public FornecedorTest() {
    }

    @Test
    public void testarSeVaiCriarUmFornecedor() {
        Fornecedor cli = new Fornecedor();
        cli.setNome("Fornecedor de Qualquer Coisa.");
        cli.setAtivo(true);
        cli.setRepresentante("Representante do Fornecedor");
        cli.setCelular("2788989899");
        cli.setFixo("2733334444");
        cli.setCpf_cnpj("82899320734");
        cli.setTipo_pessoa("jurídica");
        cli.setEmail("wander.silva@gmail.com");
        cli.setObs("Teste de inserção de dados.");
        cli.getEndereco().setCep("29032268");
        cli.getEndereco().setBairro("Santo Antonio");
        cli.getEndereco().setLogradouro("Trav xyz");
        cli.getEndereco().setNumero(1098);
        cli.getEndereco().setUf("ES");
        cli.getEndereco().setCidade("Vitória");
        FornecedorDAO dao = new FornecedorDAO();
        dao.inserir(cli);

    }

}
