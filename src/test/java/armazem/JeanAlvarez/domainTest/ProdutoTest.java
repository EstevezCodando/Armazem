package armazem.JeanAlvarez.domainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.domain.Produto;

public class ProdutoTest {

    private Produto produto;
    private Fornecedor fornecedor;
    private Endereco endereco;
    private Categoria categoria;

    @BeforeEach
    void setUp() {
        
        categoria = new Categoria(2, "Alcoólicas", "Bebidas com teor alcoólico", null);

        
        endereco = new Endereco("20000-000", "Rua dos Fornecedores", "100", "Centro", "Cidade X", "Estado Y");

        
        fornecedor = new Fornecedor(1, "Distribuidora de Bebidas S.A.", "12.345.678/0001-99", "Distribuidora X", "Distri X", "1234-5678", endereco);

       
        produto = new Produto(
            1,
            "Cachaça 51",
            "Müller",
            "985 ml",
            "Cachaça brasileira popular",
            categoria,
            "7896541239876",
            12.00,
            20.00,
            100,
            Collections.singletonList(fornecedor),
            Collections.emptyList()
        );
    }

    @Test
    void testaConstrutorProduto() {
        assertEquals(1, produto.getIdProduto());
        assertEquals("Cachaça 51", produto.getNome());
        assertEquals("Müller", produto.getMarca());
        assertEquals("985 ml", produto.getVolume());
        assertEquals("Cachaça brasileira popular", produto.getDescricao());
        assertEquals(categoria, produto.getCategoria());
        assertEquals("7896541239876", produto.getCodigodeBarras());
        assertEquals(12.00, produto.getPrecoAquisicao());
        assertEquals(20.00, produto.getPrecoVenda());
        assertEquals(100, produto.getQuantidadeEstoque());
        assertNotNull(produto.getFornecedores());
        assertNotNull(produto.getHistoricoPreco());
        assertEquals(1, produto.getFornecedores().size());
    }

    @Test
    void testaSettersProduto() {
        produto.setPrecoAquisicao(13.50);
        produto.setPrecoVenda(25.00);
        produto.setQuantidadeEstoque(150);

        assertEquals(13.50, produto.getPrecoAquisicao());
        assertEquals(25.00, produto.getPrecoVenda());
        assertEquals(150, produto.getQuantidadeEstoque());
    }

    @Test
    void testaRelacoesProduto() {
        assertEquals(endereco, fornecedor.getEndereco());
        assertEquals("Alcoólicas", categoria.getNome());
        assertEquals(fornecedor, produto.getFornecedores().get(0));
    }
}