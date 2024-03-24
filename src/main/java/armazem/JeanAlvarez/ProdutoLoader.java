package armazem.JeanAlvarez;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.domain.Produto;
import armazem.JeanAlvarez.model.service.CategoriaService;
import armazem.JeanAlvarez.model.service.FornecedorService;
import armazem.JeanAlvarez.model.service.HistoricoPrecoService;
import armazem.JeanAlvarez.model.service.ProdutoService;

@Component
@Order(4)
public class ProdutoLoader implements ApplicationRunner {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private HistoricoPrecoService historicoPrecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Categoria bebidas = new Categoria(1, "Bebidas", "Líquido para consumo humano", null);
        Categoria alcoolicas = new Categoria(2, "Alcoólicas", "bebidas com teor de alcool em sua composição ", bebidas);

        categoriaService.incluir(bebidas);
        categoriaService.incluir(alcoolicas);

      
        var fornecedorNestle = fornecedorService.obter(1); 
        var fornecedorAmbev = fornecedorService.obter(2); 

        Produto Cachaca51 = new Produto(1, "Cachaça 51", "Müller", "985 ml", "Cachaça brasileira popular",
                alcoolicas, "7896541239876", 12.00, 20.00, 100, Collections.singletonList(fornecedorNestle), null);
        Produto VodkaAbsolut = new Produto(2, "Vodka Absolut", "Absolut", "750 ml", "Vodka sueca", alcoolicas,
                "7896541239999", 30.00, 45.00, 50, Collections.singletonList(fornecedorAmbev), null);

        produtoService.incluir(Cachaca51);
        produtoService.incluir(VodkaAbsolut);
        produtoService.alterarPrecoVenda(1, 22.00);

        System.out.println("Detalhes e Histórico de Preços do Produto 1:");
        historicoPrecoService.imprimirDetalhesEHistorico(Cachaca51);

        System.out.println("Detalhes e Histórico de Preços do Produto 2:");
        historicoPrecoService.imprimirDetalhesEHistorico(VodkaAbsolut);
    }
}