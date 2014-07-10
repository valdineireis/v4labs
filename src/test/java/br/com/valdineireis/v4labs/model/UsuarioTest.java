package br.com.valdineireis.v4labs.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author valdineireis
 */
public class UsuarioTest {
    
    @Test
    public void deveIniciarInativo() {
        Usuario novo = new Usuario();
        
        assertEquals("O nome deve estar em branco", "", novo.getNome());
        assertEquals("O login deve estar em branco", "", novo.getLogin());
        assertEquals("A senha deve estar em branco", "", novo.getSenha());
        assertFalse("Deve estar inativo (false)", novo.isAtivo());
        assertEquals("Não deve ter perfis", 0, novo.getPerfis().size());
    }
}
