/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.FiadoDAO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wanderlei
 */
public class FiadosTest {
    
    public FiadosTest() {
    }
  
    @Test
    public void testarSeVaiGerarTabelaAutomaticamente(){
        new FiadoDAO();
    }
}
