/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.wander.restaurante.dao.UsuarioDAO;
import com.wander.restaurante.entidades.Usuario;
import org.junit.Test;

/**
 *
 * @author Wanderlei
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @Test
    public void testarSeCriouUmUsuarioComEnderecoTest(){
        Usuario usuario = new Usuario();
        usuario.getEndereco().setCep("29032470");
        usuario.getEndereco().setLogradouro("Rua");
        usuario.getEndereco().setNumero("91");
        usuario.getEndereco().setBairro("Santo André");
        usuario.getEndereco().setCidade("Vitória");
        usuario.getEndereco().setUf("ES");
        usuario.setLogin("wander");
        usuario.setNome("Wanderlei Silva do Carmo");
        usuario.setEmail("wander.silva@gmail.com");
        usuario.setSenha("123");
        usuario.getPerfil().setNome("Admin");
        
        new UsuarioDAO().inserir(usuario);
    }
}
