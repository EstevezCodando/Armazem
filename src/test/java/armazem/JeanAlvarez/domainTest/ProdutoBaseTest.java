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
        categoria = new Categoria("0003", "Categoria Teste", "Descrição da Categoria Teste", null);
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
    }
}