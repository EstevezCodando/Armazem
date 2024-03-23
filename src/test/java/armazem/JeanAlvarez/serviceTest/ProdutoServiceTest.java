package armazem.JeanAlvarez.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;

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

    @BeforeEach
    void setUp() {
        historicoPrecoService = new HistoricoPrecoService();
        produtoService = new ProdutoService(historicoPrecoService);

        Categoria categoria = new Categoria("0001", "Bebidas", "Líquido para consumo humano", null);
        Fornecedor fornecedor = new Fornecedor("F001", "Distribuidora de Bebidas S.A.", "12.345.678/0001-99", "Distribuidora X", "Distri X", "1234-5678", null);

        produto = new Produto(
            "P001",
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

        produtoService.incluir(produto);
    }

    @Test
    void testIncluirProduto() {
        assertNotNull(produtoService.obter(produto.getIdProduto()));
        assertEquals(1, historicoPrecoService.obterLista().size());
    }

    @Test
    void testAlterarPrecoAquisicao() {
        produtoService.alterarPrecoAquisicao(produto.getIdProduto(), 15.00);
        HistoricoPreco ultimoHistorico = historicoPrecoService.obterUltimoHistorico();
        assertNotNull(ultimoHistorico);
        assertEquals(15.00, ultimoHistorico.getPrecoAquisicaoAtual());
        assertEquals(12.00, ultimoHistorico.getPrecoAquisicaoAntigo());
    }

    @Test
    void testAlterarPrecoVenda() {
        produtoService.alterarPrecoVenda(produto.getIdProduto(), 25.00);
        HistoricoPreco ultimoHistorico = historicoPrecoService.obterUltimoHistorico();
        assertNotNull(ultimoHistorico);
        assertEquals(25.00, ultimoHistorico.getPrecoVendaAtual());
        assertEquals(20.00, ultimoHistorico.getPrecoVendaAntigo());
    }
}