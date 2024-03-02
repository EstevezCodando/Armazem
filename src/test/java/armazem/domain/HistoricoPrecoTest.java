package armazem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.domain.HistoricoPreco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class HistoricoPrecoTest {

    private HistoricoPreco historicoPreco;
    private final LocalDateTime dataAlteracao = LocalDateTime.now();
    private final String idProduto = "001";
    private final Double precoAquisicaoAntigo = 100.0;
    private final Double precoVendaAntigo = 150.0;
    private final Double precoAquisicaoAtual = 110.0;
    private final Double precoVendaAtual = 160.0;

    @BeforeEach
    public void setUp() {
        historicoPreco = new HistoricoPreco(idProduto, dataAlteracao, precoAquisicaoAntigo, precoVendaAntigo, precoAquisicaoAtual, precoVendaAtual);
    }

    @Test
    public void testGetIdProduto() {
        assertEquals(idProduto, historicoPreco.getIdProduto());
    }

    @Test
    public void testSetIdProduto() {
        String novoId = "002";
        historicoPreco.setIdProduto(novoId);
        assertEquals(novoId, historicoPreco.getIdProduto());
    }

    @Test
    public void testGetDataAlteracao() {
        assertEquals(dataAlteracao, historicoPreco.getDataAlteracao());
    }

    @Test
    public void testSetDataAlteracao() {
        LocalDateTime novaData = dataAlteracao.plusDays(1);
        historicoPreco.setDataAlteracao(novaData);
        assertEquals(novaData, historicoPreco.getDataAlteracao());
    }

    @Test
    public void testGetPrecoAquisicaoAntigo() {
        assertEquals(precoAquisicaoAntigo, historicoPreco.getPrecoAquisicaoAntigo());
    }

    @Test
    public void testSetPrecoAquisicaoAntigo() {
        Double novoPreco = 105.0;
        historicoPreco.setPrecoAquisicaoAntigo(novoPreco);
        assertEquals(novoPreco, historicoPreco.getPrecoAquisicaoAntigo());
    }

    @Test
    public void testGetPrecoVendaAntigo() {
        assertEquals(precoVendaAntigo, historicoPreco.getPrecoVendaAntigo());
    }

    @Test
    public void testSetPrecoVendaAntigo() {
        Double novoPreco = 155.0;
        historicoPreco.setPrecoVendaAntigo(novoPreco);
        assertEquals(novoPreco, historicoPreco.getPrecoVendaAntigo());
    }

    @Test
    public void testGetPrecoAquisicaoAtual() {
        assertEquals(precoAquisicaoAtual, historicoPreco.getPrecoAquisicaoAtual());
    }

    @Test
    public void testSetPrecoAquisicaoAtual() {
        Double novoPreco = 115.0;
        historicoPreco.setPrecoAquisicaoAtual(novoPreco);
        assertEquals(novoPreco, historicoPreco.getPrecoAquisicaoAtual());
    }

    @Test
    public void testGetPrecoVendaAtual() {
        assertEquals(precoVendaAtual, historicoPreco.getPrecoVendaAtual());
    }

    @Test
    public void testSetPrecoVendaAtual() {
        Double novoPreco = 165.0;
        historicoPreco.setPrecoVendaAtual(novoPreco);
        assertEquals(novoPreco, historicoPreco.getPrecoVendaAtual());
    }

    @Test
    public void testToString() {
        String expected = "HistoricoPreco [idProduto=" + idProduto + ", dataAlteracao=" + dataAlteracao + ", precoAquisicaoAntigo="
                + precoAquisicaoAntigo + ", precoVendaAntigo=" + precoVendaAntigo + ", precoAquisicaoAtual="
                + precoAquisicaoAtual + ", precoVendaAtual=" + precoVendaAtual + "]";
        assertEquals(expected, historicoPreco.toString());
    }
}
