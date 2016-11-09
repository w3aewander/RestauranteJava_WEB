/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.ComandaDAO;
import com.wander.restaurante.dao.ItemConsumoDAO;
import com.wander.restaurante.entidades.Comanda;
import com.wander.restaurante.entidades.ItemConsumo;
import com.wander.restaurante.entidades.Produto;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author Wanderlei
 */
public class ComandaTest {

    @Test
    public void testarSeVaiCriarUmaComandaTest() {

        Comanda comanda = new Comanda();
        comanda.setStatus("aberta");
        ComandaDAO dao = new ComandaDAO();

        dao.addItem(new Produto(2L), 5.0);
        dao.addItem(new Produto(1L), 2.0);
        dao.addItem(new Produto(4L), 1.0);

        dao.inserir(comanda);
    }

    @Test
    public void testarSeVaiListarItensComandaTest() throws SQLException {

        new ComandaDAO().itensComanda().stream().forEach( (o) -> {
             for(Object s: o){
                System.out.print(s);
             }
             System.out.println("\n");
        });

    }
    

    @Test
    public void testarSeVaiListarItensDeUmaComandaTest() throws SQLException {

        new ComandaDAO().itensComanda(14L).stream().forEach( (o) -> {
            
            System.out.printf("%10d  %-30s  %8.2f  %8.2f  %8.2f  %20s\n",  o[0], o[1], o[2], o[3],  o[4], o[5] );
            
        });

    }    
}
