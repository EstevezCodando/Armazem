package armazem.JeanAlvarez.domainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Categoria;

public class CategoriaTest {

    private Categoria categoria;
    private final String ID = "0001";
    private final String NOME = "Bebidas";
    private final String DESCRICAO = "Líquido para consumo humano";

    @BeforeEach
    void setUp() {
        categoria = new Categoria(ID, NOME, DESCRICAO, null);
    }

    @Test
    void testaConstrutorCategoria() {
        assertEquals(ID, categoria.getId());
        assertEquals(NOME, categoria.getNome());
        assertEquals(DESCRICAO, categoria.getDescricao());
        assertNull(categoria.getCategoriaPai());
    }

    @Test
    void testaCategoriaPai() {
        Categoria subcategoria = new Categoria("0002", "Alcoólicas", "Bebidas com teor alcoólico", categoria);

        assertEquals("Alcoólicas", subcategoria.getNome());
        assertEquals(categoria, subcategoria.getCategoriaPai());
        assertEquals("Bebidas", subcategoria.getCategoriaPai().getNome());
    }

    @Test
    void testaSettersCategoria() {
        categoria.setId("0003");
        categoria.setNome("Não Alcoólicas");
        categoria.setDescricao("Bebidas sem teor alcoólico");

        assertEquals("0003", categoria.getId());
        assertEquals("Não Alcoólicas", categoria.getNome());
        assertEquals("Bebidas sem teor alcoólico", categoria.getDescricao());
    }
}
