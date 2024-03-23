package armazem.JeanAlvarez.domainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Fornecedor;

public class FornecedorTest {

    private Fornecedor fornecedor;
    private final String ID = "F001";
    private final String RAZAO_SOCIAL = "Distribuidora de Bebidas S.A.";
    private final String CNPJ = "12.345.678/0001-99";
    private final String NOME = "Distribuidora X";
    private final String NOME_FANTASIA = "Distri X";
    private final String TELEFONE = "1234-5678";
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        endereco = new Endereco("20000-000", "Rua dos Fornecedores", "100", "Centro", "Cidade X", "Estado Y");
        fornecedor = new Fornecedor(ID, RAZAO_SOCIAL, CNPJ, NOME, NOME_FANTASIA, TELEFONE, endereco);
    }

    @Test
    void testaConstrutorFornecedor() {
        assertEquals(ID, fornecedor.getId());
        assertEquals(RAZAO_SOCIAL, fornecedor.getRazaoSocial());
        assertEquals(CNPJ, fornecedor.getCnpj());
        assertEquals(NOME, fornecedor.getNome());
        assertEquals(NOME_FANTASIA, fornecedor.getNomeFantasia());
        assertEquals(TELEFONE, fornecedor.getTelefone());
        assertEquals(endereco, fornecedor.getEndereco());
    }

    @Test
    void testaSettersFornecedor() {
        String novoCnpj = "98.765.432/0001-11";
        fornecedor.setCnpj(novoCnpj);
        assertEquals(novoCnpj, fornecedor.getCnpj());

        String novoTelefone = "8765-4321";
        fornecedor.setTelefone(novoTelefone);
        assertEquals(novoTelefone, fornecedor.getTelefone());
    }
}
