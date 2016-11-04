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
import org.junit.Test;

/**
 *
 * @author Wanderlei
 */
public final class ProdutoTest {

    @Test
    public void testarSeVaiAtualizarUmProduto() {
        Produto produto = new Produto();
        produto.setId(5L);
        produto.getUnidade().setId(1L);
        //produto.setValorUnitario(500.00);
        produto.setNome("Produto 5");

        new ProdutoDAO().atualizar(produto);
    }

    @Test
    public void testarSeVaiCriarUmProduto() {

        Produto produto = new Produto();
        produto.setNome("Produto 10");
        produto.setCreated_at(Calendar.getInstance().getTime());
        produto.getUnidade().setId(2L);
        produto.getUnidade().setNome("Litro");
        produto.setValorUnitario(1500.00);

        new ProdutoDAO().inserir(produto);
    }

    @Test
    public void testarSeVaiListarProdutos() {

        new ProdutoDAO().listar().stream().forEach((p) -> {
            System.out.println(
                    p.getUnidade().getNome() + " - "
                    + new SimpleDateFormat("dd/MM/yyyy")
                    .format(p.getCreated_at()) + " - "+  p.getNome()
                    + " - "
                    + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(p.getUpdated_at()));
        }
        );
    }
}
