package br.com.valdineireis.v4labs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.valdineireis.v4labs.helper.UsuarioHelperTest;
import br.com.valdineireis.v4labs.model.Usuario;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

/**
 *
 * @author Valdinei Reis (valdineimtz@gmail.com)
 */
public class UsuarioDaoTest {

    private final JIntegrity helper = new JIntegrity();

    private UsuarioDAO dao;

    @BeforeClass
    public static void setUpClass() {
        JPAHelper.entityManagerFactory("cm_test");
    }

    @Before
    public void setUp() {
        helper.useMySQL();

        helper.cleanAndInsert();

        this.dao = new JPAUsuarioDAO(JPAHelper.currentEntityManager());
    }

    @After
    public void tearDown() {
        JPAHelper.close();
    }

    @Test
    public void deveriaBuscarPorLoginESenha() {
        // given
//        Perfil perfil = new Perfil();
        Usuario joao = UsuarioHelperTest.Novo(1l, "João", "joao", true, null);

        // when
        Usuario esperado = dao.busca(joao.getLogin(), joao.getSenha());

        // then
        verifyEntities(joao, esperado);
    }

    @Test
    public void deveriaRetornarNullAoBuscarPorLoginESenha() {
        // given
        Usuario jose = UsuarioHelperTest.Novo("José", "jose");

        // when
        Usuario esperado = dao.busca(jose.getLogin(), jose.getSenha());

        // then
        assertNull("Não deve encontrar o usuário José", esperado);
    }

    @Test
    public void deveriaRetornarNullAoBuscarPorUsuarioInativo() {
        // given
        Usuario maria = UsuarioHelperTest.Novo("Maria", "maria");

        // when
        Usuario esperado = dao.busca(maria.getLogin(), maria.getSenha());

        // then
        assertNull("Não deve encontrar o usuário José", esperado);
    }

    @Test
    public void deveriaListarTodos() {
        // given

        // when
        List<Usuario> entityList = (List<Usuario>) dao.listaTodos();

        // then
        assertEquals("deve retornar a quantidade correta de registros", 2, entityList.size());

        verifyEntities(UsuarioHelperTest.Novo(1l, "João", "joao", true, null), entityList.get(0));
        verifyEntities(UsuarioHelperTest.Novo(2l, "Maria", "maria", false, null), entityList.get(1));
    }

    @Test
    public void deveriaBuscarUsuarioPorId() {

        // when
        Usuario joao = dao.buscarPorId(1l);
        Usuario maria = dao.buscarPorId(2l);

        // then
        verifyEntities(UsuarioHelperTest.Novo(1l, "João", "joao", true, null), joao);
        verifyEntities(UsuarioHelperTest.Novo(2l, "Maria", "maria", false, null), maria);
    }
    
    @Test
    public void deveriaExistirUsuarioComLoginX() {
        assertTrue("Deve exisitir usuário", dao.contemUsuarioComLogin("joao"));
    }
    
    @Test
    public void deveNaoExistirUsuarioComLoginX() {
        assertFalse("Não deve existir usuário", dao.contemUsuarioComLogin("jose"));
    }

    private void verifyEntities(Usuario expected, Usuario found) {
        assertEquals("deve ter o mesmo login", expected.getLogin(), found.getLogin());
        assertEquals("deve ter o mesmo nome", expected.getNome(), found.getNome());
        assertEquals("deve ter a mesma senha", expected.getSenha(), found.getSenha());
        assertEquals("deve ter o mesmo status", expected.isAtivo(), found.isAtivo());
        assertEquals("deve ter o mesmo salt", expected.getSalt(), found.getSalt());
    }

}
