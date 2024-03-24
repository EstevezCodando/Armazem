package armazem.JeanAlvarez.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.service.HistoricoPrecoService;

public class HistoricoPrecoServiceTest {

    private HistoricoPrecoService historicoPrecoService;
    private HistoricoPreco historicoPreco1;
    private HistoricoPreco historicoPreco2;

    @BeforeEach
    void setUp() {
        historicoPrecoService = new HistoricoPrecoService();

        LocalDateTime dataAlteracao1 = LocalDateTime.of(2021, 6, 15, 10, 0);
        historicoPreco1 = new HistoricoPreco(1, dataAlteracao1, 10.0, 15.0, 12.0, 18.0);
        historicoPrecoService.incluir(historicoPreco1);

        LocalDateTime dataAlteracao2 = LocalDateTime.of(2021, 7, 20, 11, 0);
        historicoPreco2 = new HistoricoPreco(1, dataAlteracao2, 12.0, 18.0, 14.0, 20.0);
        historicoPrecoService.incluir(historicoPreco2);
    }

    @Test
    void testIncluirEObterHistorico() {
        assertNotNull(historicoPrecoService.obterLista());
        assertTrue(historicoPrecoService.obterLista().contains(historicoPreco1));
        assertTrue(historicoPrecoService.obterLista().contains(historicoPreco2));
    }

    @Test
    void testObterUltimoHistorico() {
        HistoricoPreco ultimoHistorico = historicoPrecoService.obterUltimoHistoricoPorProdutoID(1);
        assertNotNull(ultimoHistorico);
        assertEquals(historicoPreco2.getDataAlteracao(), ultimoHistorico.getDataAlteracao());
    }

    @Test
    void testObterListaHistoricoPreco() {
        Collection<HistoricoPreco> lista = historicoPrecoService.obterLista();
        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertTrue(lista.contains(historicoPreco1));
        assertTrue(lista.contains(historicoPreco2));
    }
}