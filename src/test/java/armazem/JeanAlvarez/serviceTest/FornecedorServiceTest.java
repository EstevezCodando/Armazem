package armazem.JeanAlvarez.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.service.FornecedorService;

public class FornecedorServiceTest {

    private FornecedorService fornecedorService;
    private Fornecedor fornecedor;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        fornecedorService = new FornecedorService();

        endereco = new Endereco("20000-000", "Rua dos Fornecedores", "100", "Centro", "Cidade X", "Estado Y");
        fornecedor = new Fornecedor("F001", "Distribuidora de Bebidas S.A.", "12.345.678/0001-99", "Distribuidora X", "Distri X", "1234-5678", endereco);

        fornecedorService.incluir(fornecedor);
    }

    @Test
    void testIncluirEObterFornecedor() {
        Fornecedor obtido = fornecedorService.obter(fornecedor.getId());
        assertNotNull(obtido);
        assertEquals(fornecedor.getId(), obtido.getId());
        assertEquals(fornecedor.getNome(), obtido.getNome());
        assertEquals(fornecedor.getRazaoSocial(), obtido.getRazaoSocial());
    }

    @Test
    void testObterListaFornecedores() {
        Collection<Fornecedor> lista = fornecedorService.obterLista();
        assertNotNull(lista);
        assertTrue(lista.contains(fornecedor));
    }

    @Test
    void testAtualizarFornecedor() {
        Fornecedor novoFornecedor = new Fornecedor(fornecedor.getId(), "Distribuidora de Bebidas Novo S.A.", "98.765.432/0001-01", "Distribuidora Y", "Distri Y", "4321-8765", endereco);
        assertTrue(fornecedorService.atualizar(fornecedor.getId(), novoFornecedor));

        Fornecedor atualizado = fornecedorService.obter(fornecedor.getId());
        assertNotNull(atualizado);
        assertEquals(novoFornecedor.getNome(), atualizado.getNome());
        assertEquals(novoFornecedor.getRazaoSocial(), atualizado.getRazaoSocial());
    }

    @Test
    void testExcluirFornecedor_QueNaoExiste() {
        assertFalse(fornecedorService.excluir("F002")); // Espera-se que retorne falso porque o fornecedor não existe
    }

    @Test
    void testAtualizarFornecedor_QueNaoExiste() {
        Endereco novoEndereco = new Endereco("20000-000", "Rua dos Atualizados", "101", "Centro", "Cidade Y", "Estado Z");
        Fornecedor novoFornecedor = new Fornecedor("F002", "Distribuidora Atualizada S.A.", "98.765.432/0001-01", "Distribuidora Y", "Distri Y", "8765-4321", novoEndereco);

        assertFalse(fornecedorService.atualizar("F002", novoFornecedor)); // Espera-se que retorne falso, pois o fornecedor não existe
    }

    @Test
    void testExcluirFornecedor() {
        fornecedorService.incluir(fornecedor); // Garantir que o fornecedor está incluído antes de excluir
        assertTrue(fornecedorService.excluir(fornecedor.getId())); // Espera-se que retorne verdadeiro, pois o fornecedor existe

        Fornecedor excluido = fornecedorService.obter(fornecedor.getId());
        assertNull(excluido);
    }
}