/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.wander.restaurante.dao.UnidadeDAO;
import com.wander.restaurante.entidades.Unidade;
import java.util.List;
/**
 *
 * @author Wanderlei
 */
public class RestauranteTest {
    
    @Test
    public void testarSeUnidadeFoiSalvaTest(){
        Unidade unidade = new Unidade(); 
        unidade.setNome("Dúzia");    
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
        Unidade u = new Unidade(4L,"Peça");
        new UnidadeDAO().atualizar(u);
    }
}
