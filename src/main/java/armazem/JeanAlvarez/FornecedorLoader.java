package armazem.JeanAlvarez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.service.FornecedorService;
import armazem.JeanAlvarez.model.service.LocalidadeService;

@Component
@Order(3)
public class FornecedorLoader implements ApplicationRunner {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private LocalidadeService localidadeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Endereco enderecoNestle = localidadeService.obterPorCep("04538-133");
        Fornecedor nestle = new Fornecedor(001, "Nestlé Brasil Ltda", "60.915.990/0001-23", "Nestlé", "Nestlé", "0800 770 2411", enderecoNestle);
        fornecedorService.incluir(nestle);

        Endereco enderecoAmbev = localidadeService.obterPorCep("05003-900");
        Fornecedor ambev = new Fornecedor(002, "Ambev S.A.", "07.526.557/0001-00", "Ambev", "Ambev", "0800 725 0001", enderecoAmbev);
        fornecedorService.incluir(ambev);

        Endereco enderecoUnilever = localidadeService.obterPorCep("04571-010");
        Fornecedor unilever = new Fornecedor(003, "Unilever Brasil Ltda", "61.068.276/0001-04", "Unilever", "Unilever", "0800 707 7512", enderecoUnilever);
        fornecedorService.incluir(unilever);

        Endereco enderecoCargill = localidadeService.obterPorCep("01451-000");
        Fornecedor cargill = new Fornecedor(004, "Cargill Agrícola S.A.", "60.498.706/0001-46", "Cargill", "Cargill", "0800 648 0808", enderecoCargill);
        fornecedorService.incluir(cargill);
    }
}
