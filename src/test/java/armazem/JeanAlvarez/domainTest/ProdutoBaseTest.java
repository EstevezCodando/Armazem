package armazem.JeanAlvarez.domainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.domain.ProdutoBase;

public class ProdutoBaseTest {

    private ProdutoBase produtoBase;
    private final String ID_PRODUTO = "P001";
    private final String NOME = "Produto Teste";
    private final String MARCA = "Marca Teste";
    private final String VOLUME = "100 ml";
    private final String DESCRICAO = "Descrição do Produto Teste";
    private final String CODIGO_DE_BARRAS = "1234567890123";
    private Categoria categoria;

    @BeforeEach
    void setUp() {
    	Categoria bebidas = new Categoria("0001", "Bebidas", "Líquido para consumo humano", null);
        produtoBase = new ProdutoBase(ID_PRODUTO, NOME, MARCA, VOLUME, DESCRICAO, categoria, CODIGO_DE_BARRAS);
    }

    @Test
    void testaConstrutorProdutoBase() {
        assertEquals(ID_PRODUTO, produtoBase.getIdProduto());
        assertEquals(NOME, produtoBase.getNome());
        assertEquals(MARCA, produtoBase.getMarca());
        assertEquals(VOLUME, produtoBase.getVolume());
        assertEquals(DESCRICAO, produtoBase.getDescricao());
        assertEquals(categoria, produtoBase.getCategoria());
        assertEquals(CODIGO_DE_BARRAS, produtoBase.getCodigodeBarras());
    }

    @Test
    void testaSettersProdutoBase() {
        String novoNome = "Produto Alterado";
        produtoBase.setNome(novoNome);
        assertEquals(novoNome, produtoBase.getNome());

        String novaDescricao = "Descrição Alterada";
        produtoBase.setDescricao(novaDescricao);
        assertEquals(novaDescricao, produtoBase.getDescricao());
        
        String novaVolume = "2030ml";
        produtoBase.setVolume(novaVolume);
        assertEquals(novaVolume, produtoBase.getVolume());
        
        String novaCodigoDeBarras = "203032444";
        produtoBase.setCodigodeBarras(novaCodigoDeBarras);
        assertEquals(novaCodigoDeBarras, produtoBase.getCodigodeBarras());
        
        String novaMarca = "DJGO4";
        produtoBase.setMarca(novaMarca);
        assertEquals(novaMarca, produtoBase.getMarca());
        
        Categoria alcoolicas = new Categoria("0002", "Alcoólicas", "As bebidas alcoólicas", null);
        produtoBase.setCategoria(alcoolicas);
        assertEquals(alcoolicas, produtoBase.getCategoria());
        
    }
}