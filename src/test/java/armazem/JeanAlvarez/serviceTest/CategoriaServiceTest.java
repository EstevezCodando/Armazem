package armazem.JeanAlvarez.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.service.CategoriaService;

public class CategoriaServiceTest {

    private CategoriaService categoriaService;
    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoriaService = new CategoriaService();
        categoria = new Categoria("001", "Bebidas", "Bebidas de diversos tipos", null);
        categoriaService.incluir(categoria);
    }

    @Test
    void testIncluirEObterCategoria() {
        Categoria obtida = categoriaService.obter(categoria.getId());
        assertNotNull(obtida);
        assertEquals(categoria.getId(), obtida.getId());
        assertEquals(categoria.getNome(), obtida.getNome());
        assertEquals(categoria.getDescricao(), obtida.getDescricao());
    }

    @Test
    void testObterListaCategorias() {
        Collection<Categoria> lista = categoriaService.obterLista();
        assertNotNull(lista);
        assertTrue(lista.contains(categoria));
    }

    @Test
    void testAtualizarCategoria() {
        Categoria novaCategoria = new Categoria(categoria.getId(), "Alimentos", "Produtos alimentícios", null);
        categoriaService.atualizar(categoria.getId(), novaCategoria);

        Categoria atualizada = categoriaService.obter(categoria.getId());
        assertNotNull(atualizada);
        assertEquals("Alimentos", atualizada.getNome());
        assertEquals("Produtos alimentícios", atualizada.getDescricao());
    }

    @Test
    void testExcluirCategoria() {
        categoriaService.excluir(categoria.getId());
        Categoria excluida = categoriaService.obter(categoria.getId());
        assertNull(excluida);
    }
}