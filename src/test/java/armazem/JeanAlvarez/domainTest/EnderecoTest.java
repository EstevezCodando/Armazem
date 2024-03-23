package armazem.JeanAlvarez.domainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import armazem.JeanAlvarez.model.domain.Endereco;

public class EnderecoTest {

    private Endereco endereco;
    private final String CEP = "20000-000";
    private final String LOGRADOURO = "Rua dos Fornecedores";
    private final String COMPLEMENTO = "Loja 1";
    private final String BAIRRO = "Centro";
    private final String LOCALIDADE = "Cidade X";
    private final String UF = "Estado Y";

    @BeforeEach
    void setUp() {
        endereco = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, BAIRRO, LOCALIDADE, UF);
    }

    @Test
    void testaConstrutorEndereco() {
        assertEquals(CEP, endereco.getCep());
        assertEquals(LOGRADOURO, endereco.getLogradouro());
        assertEquals(COMPLEMENTO, endereco.getComplemento());
        assertEquals(BAIRRO, endereco.getBairro());
        assertEquals(LOCALIDADE, endereco.getLocalidade());
        assertEquals(UF, endereco.getUf());
    }

    @Test
    void testaSettersEndereco() {
        String novoCep = "22000-000";
        endereco.setCep(novoCep);
        assertEquals(novoCep, endereco.getCep());

        String novaLocalidade = "Cidade Y";
        endereco.setLocalidade(novaLocalidade);
        assertEquals(novaLocalidade, endereco.getLocalidade());
    }
}
