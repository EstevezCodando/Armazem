package armazem.JeanAlvarez.domainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;

public class HistoricoPrecoTest {

    private HistoricoPreco historicoPreco;
    private final Integer ID_PRODUTO = 1;
    private final LocalDateTime DATA_ALTERACAO = LocalDateTime.now();
    private final double PRECO_AQUISICAO_ANTIGO = 10.00;
    private final double PRECO_VENDA_ANTIGO = 15.00;
    private final double PRECO_AQUISICAO_ATUAL = 12.00;
    private final double PRECO_VENDA_ATUAL = 18.00;

    @BeforeEach
    void setUp() {
        historicoPreco = new HistoricoPreco(
            ID_PRODUTO, 
            DATA_ALTERACAO, 
            PRECO_AQUISICAO_ANTIGO, 
            PRECO_VENDA_ANTIGO, 
            PRECO_AQUISICAO_ATUAL, 
            PRECO_VENDA_ATUAL
        );
    }

    @Test
    void testaConstrutorHistoricoPreco() {
        assertEquals(ID_PRODUTO, historicoPreco.getIdProduto());
        assertEquals(DATA_ALTERACAO, historicoPreco.getDataAlteracao());
        assertEquals(PRECO_AQUISICAO_ANTIGO, historicoPreco.getPrecoAquisicaoAntigo());
        assertEquals(PRECO_VENDA_ANTIGO, historicoPreco.getPrecoVendaAntigo());
        assertEquals(PRECO_AQUISICAO_ATUAL, historicoPreco.getPrecoAquisicaoAtual());
        assertEquals(PRECO_VENDA_ATUAL, historicoPreco.getPrecoVendaAtual());
    }

    @Test
    void testaSettersHistoricoPreco() {
        double novoPrecoAquisicaoAtual = 13.00;
        historicoPreco.setPrecoAquisicaoAtual(novoPrecoAquisicaoAtual);
        assertEquals(novoPrecoAquisicaoAtual, historicoPreco.getPrecoAquisicaoAtual());

        double novoPrecoVendaAtual = 20.00;
        historicoPreco.setPrecoVendaAtual(novoPrecoVendaAtual);
        assertEquals(novoPrecoVendaAtual, historicoPreco.getPrecoVendaAtual());
    }
}
