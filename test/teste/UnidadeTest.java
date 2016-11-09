
package teste;

import org.junit.Test;
import static org.junit.Assert.*;
import com.wander.restaurante.dao.UnidadeDAO;
import com.wander.restaurante.entidades.Unidade;
/**
 *
 * @author Wanderlei
 */
public class UnidadeTest {
    
    @Test
    public void testarSeUnidadeFoiSalvaTest(){
        Unidade unidade = new Unidade(); 
        unidade.setNome("Porção");    
        new UnidadeDAO().inserir(unidade);
    }
    @Test
    public void testarSeEncontraUnidadeSalvaTest(){
        
        Unidade u = (Unidade) new UnidadeDAO().pesquisar(2L);
        assertTrue("Dúzia".equals(u.getNome()));
    }
    
    
    @Test
    public void testarSeVaiListarUnidades(){
       
        new UnidadeDAO().listar().stream().forEach((u) -> {
            System.out.println(u.getId() + " - " + u.getNome());
        });
    }
    
    @Test
    public void testarSeVaiAtualizarUnidadeTest(){
        Unidade u = new Unidade(1L, "Litro");
        new UnidadeDAO().atualizar(u);
    }
    
    @Test
    public void testarSeVaiExcluirUmaUnidade(){
        Unidade u = new Unidade();
        u.setId(6L);
        new UnidadeDAO().excluir(u);
    }
    
}
