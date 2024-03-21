package armazem.JeanAlvarez;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.service.CategoriaService;
import armazem.JeanAlvarez.model.service.FornecedorService;
import armazem.JeanAlvarez.model.service.HistoricoPrecoService;
import armazem.JeanAlvarez.model.service.ProdutoService;

@Component
public class ProdutoLoader implements ApplicationRunner {

    private ProdutoService produtoService = new ProdutoService();
    private CategoriaService categoriaService = new CategoriaService();
    private FornecedorService fornecedorService = new FornecedorService();
    private HistoricoPrecoService historicoPrecoService = new HistoricoPrecoService();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Categoria bebidas = new Categoria("0001", "Bebidas", "Líquido para consumo humano", null);
        Categoria alcoolicas = new Categoria("0002", "Alcoólicas", "As bebidas alcoólicas", bebidas);

        // Testar CategoriaService
        categoriaService.incluir(bebidas);
        categoriaService.incluir(alcoolicas);
        
        Endereco endereco = new Endereco("12345-678", "Rua dos Fornecedores", "Loja 1", "Centro", "Cidade X", "Estado Y");
        Fornecedor fornecedor = new Fornecedor("F001", "Distribuidora de Bebidas S.A.", "12.345.678/0001-99", "Distribuidora X", "Distri X", "1234-5678", endereco);

        // Testar FornecedorService
        fornecedorService.incluir(fornecedor);

       // Produto produto1 = new Produto("P001", "Cachaça 51", "Müller", "985 ml", "Cachaça brasileira popular", alcoolicas, "7896541239876", 12.00, 20.00, 100, List.of(fornecedor));
       // Produto produto2 = new Produto("P002", "Vodka Absolut", "Absolut", "750 ml", "Vodka sueca", alcoolicas, "7896541239999", 30.00, 45.00, 50, List.of(fornecedor));

        // Testar ProdutoService
        //produtoService.incluir(produto1);
        //produtoService.incluir(produto2);

        // Testar alteração de preço e histórico de preços
        //produtoService.alterar("P001", 12.00, 22.00, 100);

        // Imprimir detalhes e histórico dos produtos
       // System.out.println("Detalhes e Histórico de Preços do Produto 1:");
       // historicoPrecoService.imprimirDetalhesEHistorico(produto1);

        //System.out.println("Detalhes e Histórico de Preços do Produto 2:");
       // historicoPrecoService.imprimirDetalhesEHistorico(produto2);
    }
}
