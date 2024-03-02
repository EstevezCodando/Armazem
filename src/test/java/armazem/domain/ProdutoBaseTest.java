package armazem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.domain.Categoria;
import model.domain.ProdutoBase;

class ProdutoBaseTest {
    
    private ProdutoBase produto;
    private Categoria categoria;
    private final String ID_PRODUTO = "001";
    private final String NOME = "Água Mineral";
    private final String MARCA = "Fonte Viva";
    private final String VOLUME = "500ml";
    private final String DESCRICAO = "Água sem gás";
    private final String CODIGO_DE_BARRAS = "1234567890123";
    
    @BeforeEach
    void setUp() {
        categoria = new Categoria("0003", "Bebidas não alcoólicas", "Bebidas sem álcool", null);
        produto = new ProdutoBase(ID_PRODUTO, NOME, MARCA, VOLUME, DESCRICAO, categoria, CODIGO_DE_BARRAS);
    }
    
    @Test
    void gettersTest() {
        assertEquals(ID_PRODUTO, produto.getIdProduto());
        assertEquals(NOME, produto.getNome());
        assertEquals(MARCA, produto.getMarca());
        assertEquals(VOLUME, produto.getVolume());
        assertEquals(DESCRICAO, produto.getDescricao());
        assertEquals(categoria, produto.getCategoria());
        assertEquals(CODIGO_DE_BARRAS, produto.getCodigodeBarras());
    }
    
    @Test
    void settersTest() {
        // Criar novos valores para testar os setters
        String novoIdProduto = "002";
        String novoNome = "Suco de Laranja";
        String novaMarca = "Natur";
        String novoVolume = "1L";
        String novaDescricao = "Suco natural sem conservantes";
        Categoria novaCategoria = new Categoria("0004", "Sucos Naturais", "Sucos sem conservantes", null);
        String novoCodigoDeBarras = "9876543210987";
        
        produto.setIdProduto(novoIdProduto);
        produto.setNome(novoNome);
        produto.setMarca(novaMarca);
        produto.setVolume(novoVolume);
        produto.setDescricao(novaDescricao);
        produto.setCategoria(novaCategoria);
        produto.setCodigodeBarras(novoCodigoDeBarras);
        
        // Verificar se os setters atualizaram os valores corretamente
        assertEquals(novoIdProduto, produto.getIdProduto());
        assertEquals(novoNome, produto.getNome());
        assertEquals(novaMarca, produto.getMarca());
        assertEquals(novoVolume, produto.getVolume());
        assertEquals(novaDescricao, produto.getDescricao());
        assertEquals(novaCategoria, produto.getCategoria());
        assertEquals(novoCodigoDeBarras, produto.getCodigodeBarras());
    }
    

}
