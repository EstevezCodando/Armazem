package armazem.JeanAlvarez.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.domain.Produto;
import armazem.JeanAlvarez.model.service.HistoricoPrecoService;
import armazem.JeanAlvarez.model.service.ProdutoService;

public class ProdutoServiceTest {

    private ProdutoService produtoService;
    private HistoricoPrecoService historicoPrecoService;
    private Produto produto;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private Map<Integer, Produto> produtos;

    @BeforeEach
    void setUp() {
        historicoPrecoService = new HistoricoPrecoService();
        produtoService = new ProdutoService(historicoPrecoService);
        produtos = new HashMap<>();

        categoria = new Categoria(1, "Bebidas", "Líquido para consumo humano", null);
        fornecedor = new Fornecedor(1, "Distribuidora de Bebidas S.A.", "12.345.678/0001-99", "Distribuidora X", "Distri X", "1234-5678", null);

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
            new ArrayList<>(List.of(fornecedor)),
            new ArrayList<>()
        );

        produtoService.incluir(produto);
    }

    @Test
    void testIncluirProduto() {
        assertNotNull(produtoService.obter(produto.getIdProduto()));
        assertEquals(1, historicoPrecoService.obterLista().size());
    }
    /*
    @Test
    void testAlterarPrecoAquisicao() {
        double novoPrecoAquisicao = 15.00;
        assertTrue(produtoService.alterarPrecoAquisicao(produto.getIdProduto(), novoPrecoAquisicao));

        Produto produtoAtualizado = produtoService.obter(produto.getIdProduto());
        assertNotNull(produtoAtualizado);
        assertEquals(novoPrecoAquisicao, produtoAtualizado.getPrecoAquisicao(), 0.01);

        HistoricoPreco ultimoHistorico = historicoPrecoService.obterUltimoHistoricoPorProdutoID(produto.getIdProduto());
        assertNotNull(ultimoHistorico);
        assertEquals(novoPrecoAquisicao, ultimoHistorico.getPrecoAquisicaoAtual(), 0.01);
        assertEquals(12.00, ultimoHistorico.getPrecoAquisicaoAntigo(), 0.01);
    }

    @Test
    void testAlterarPrecoVenda() {
        double novoPrecoVenda = 25.00;
        assertTrue(produtoService.alterarPrecoVenda(produto.getIdProduto(), novoPrecoVenda));

        Produto produtoAtualizado = produtoService.obter(produto.getIdProduto());
        assertNotNull(produtoAtualizado);
        assertEquals(novoPrecoVenda, produtoAtualizado.getPrecoVenda(), 0.01);

        HistoricoPreco ultimoHistorico = historicoPrecoService.obterUltimoHistoricoPorProdutoID(produto.getIdProduto());
        assertNotNull(ultimoHistorico);
        assertEquals(novoPrecoVenda, ultimoHistorico.getPrecoVendaAtual(), 0.01);
        assertEquals(20.00, ultimoHistorico.getPrecoVendaAntigo(), 0.01);
    }
    */
}