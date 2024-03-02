package armazem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.domain.Categoria;
import model.domain.HistoricoPreco;
import model.domain.Produto;

class ProdutoTest {

    private Produto produto;
    private Categoria categoria;
    private HistoricoPreco historicoPreco;
    private final LocalDateTime dataAlteracao = LocalDateTime.now();
    
    @BeforeEach
    void setUp() {
        categoria = new Categoria("0003", "Eletrônicos", "Aparelhos eletrônicos", null);
        produto = new Produto("001", "Smartphone", "XYZ", "128GB", "Smartphone XYZ com 128GB de armazenamento", categoria, "1234567890123");
        historicoPreco = new HistoricoPreco("001", dataAlteracao, 1000.0, 1200.0, 1100.0, 1300.0);
        produto.setPrecoAquisicao(1100.0);
        produto.setPrecoVenda(1300.0);
        produto.setQuantidadeEstoque(10);
    }
    
    @Test
    void testSetEGetPrecoAquisicao() {
        assertEquals(1100.0, produto.getPrecoAquisicao());
    }

    @Test
    void testSetEGetPrecoVenda() {
        assertEquals(1300.0, produto.getPrecoVenda());
    }

    @Test
    void testSetEGetQuantidadeEstoque() {
        assertEquals(10, produto.getQuantidadeEstoque());
    }

    @Test
    void testAdicionarEGetHistoricoPreco() {
        produto.setHistoricoPreco(new HashMap<>());
        produto.getHistoricoPreco().put(dataAlteracao, historicoPreco);

        assertTrue(produto.getHistoricoPreco().containsKey(dataAlteracao));
        assertEquals(historicoPreco, produto.getHistoricoPreco().get(dataAlteracao));
    }

}
