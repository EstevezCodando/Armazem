package armazem.JeanAlvarez;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.domain.Produto;
import armazem.JeanAlvarez.model.service.CategoriaService;
import armazem.JeanAlvarez.model.service.FornecedorService;
import armazem.JeanAlvarez.model.service.HistoricoPrecoService;
import armazem.JeanAlvarez.model.service.ProdutoService;

@Component
public class ProdutoLoader implements ApplicationRunner {

    private ProdutoService produtoService;
    private CategoriaService categoriaService;
    private FornecedorService fornecedorService;
    private HistoricoPrecoService historicoPrecoService;

    public ProdutoLoader() {
        this.historicoPrecoService = new HistoricoPrecoService();
        this.produtoService = new ProdutoService(historicoPrecoService);
        this.categoriaService = new CategoriaService();
        this.fornecedorService = new FornecedorService();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Categoria bebidas = new Categoria("0001", "Bebidas", "Líquido para consumo humano", null);
        Categoria alcoolicas = new Categoria("0002", "Alcoólicas", "As bebidas alcoólicas", bebidas);

        categoriaService.incluir(bebidas);
        categoriaService.incluir(alcoolicas);

        Fornecedor fornecedor = new Fornecedor("F001", "Distribuidora de Bebidas S.A.", "12.345.678/0001-99", "Distribuidora X", "Distri X", "1234-5678", null);

        fornecedorService.incluir(fornecedor);

        Produto produto1 = new Produto("P001", "Cachaça 51", "Müller", "985 ml", "Cachaça brasileira popular", alcoolicas, "7896541239876", 12.00, 20.00, 100, Collections.singletonList(fornecedor),null);
        Produto produto2 = new Produto("P002", "Vodka Absolut", "Absolut", "750 ml", "Vodka sueca", alcoolicas, "7896541239999", 30.00, 45.00, 50, Collections.singletonList(fornecedor),null);

        produtoService.incluir(produto1);
        produtoService.incluir(produto2);
        produtoService.alterarPrecoVenda("P001", 22.00);
        
        
        System.out.println("Detalhes e Histórico de Preços do Produto 1:");
        historicoPrecoService.imprimirDetalhesEHistorico(produto1);

        System.out.println("Detalhes e Histórico de Preços do Produto 2:");
        historicoPrecoService.imprimirDetalhesEHistorico(produto2);

    }
}
