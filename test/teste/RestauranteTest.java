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
/**
 *
 * @author Wanderlei
 */
public class RestauranteTest {
    
    @Test
    public void testarSeUnidadeFoiSalvaTest(){
        Unidade unidade = new Unidade(); 
        unidade.setNome("Kg");
        
        new UnidadeDAO().inserir(unidade);
        
    }
}
