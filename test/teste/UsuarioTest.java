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
    private static Usuario usuario;
    
    public UsuarioTest() {

    }

    @Test
    public void testarSeCriouUmUsuarioComEnderecoTest() {
        usuario = new Usuario();
        
        usuario.getPerfil().setId(1);
        usuario.getPerfil().setNome("Admin");
        usuario.setLogin("wander");
        usuario.setNome("Wanderlei Silva do Carmo");
        usuario.setEmail("wander.silva@gmail.com");
        usuario.setSenha("123");
        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(usuario);
    }
}
