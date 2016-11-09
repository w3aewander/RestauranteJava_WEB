/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.ProdutoDAO;
import com.wander.restaurante.entidades.Produto;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Wanderlei
 */
public final class ProdutoTest {

    @Test
    public void testarSeVaiAtualizarUmProduto() {
        Produto produto = new Produto();
        produto.setId(2L);
        produto.getUnidade().setId(2L);
        produto.setValorUnitario(720.28);
        produto.setDescricao("Outro produto modificado");

        new ProdutoDAO().atualizar(produto);
    }

    @Test
    public void testarSeVaiCriarUmProduto() {
    
        Produto produto = new Produto();
        produto.setDescricao("Produto 5");
        produto.setCreated_at( Calendar.getInstance() );
        produto.setUpdated_at( Calendar.getInstance() );
        produto.getUnidade().setId(2L);
        produto.setValorUnitario(15.00);

        new ProdutoDAO().inserir(produto);
    }

    @Test
    public void testarSeVaiListarProdutos() {

        new ProdutoDAO().listar().stream().forEach((p) -> {
            System.out.println(
                       new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format( p.getCreated_at().getTime() ) + " - " +  p.getDescricao() )  ;
        }
        );
    }
    
    @Test
    public void testarSeVaiPesquisarUmProduto(){
        
        System.out.println(new ProdutoDAO().pesquisar(2L).toString());
        Assert.assertNotNull(new ProdutoDAO().pesquisar(2L));
    }
}
