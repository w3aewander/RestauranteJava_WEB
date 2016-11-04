/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.ProdutoDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import com.wander.restaurante.dao.UnidadeDAO;
import com.wander.restaurante.entidades.Produto;
import com.wander.restaurante.entidades.Unidade;
import java.util.Calendar;
/**
 *
 * @author Wanderlei
 */
public class UnidadeTest {
    
    @Test
    public void testarSeUnidadeFoiSalvaTest(){
        Unidade unidade = new Unidade(); 
        unidade.setNome("Peça");    
        new UnidadeDAO().inserir(unidade);
    }
    @Test
    public void testarSeEncontraUnidadeSalvaTest(){
        
        Unidade u = (Unidade) new UnidadeDAO().pesquisar(2L);
        assertTrue("Dúzia".equals(u.getNome()));
    }
    
    @Test
    public void testarSeVaiListarUnidades(){
       
        for(Unidade u: new UnidadeDAO().listar()){
            System.out.println(u.getNome());
        }
    }
    
    @Test
    public void testarSeVaiAtualizarUnidadeTest(){
        Unidade u = new Unidade(1L, "Peça");
        new UnidadeDAO().atualizar(u);
    }
    
}
