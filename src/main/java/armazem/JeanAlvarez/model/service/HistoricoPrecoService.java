package armazem.JeanAlvarez.model.service;

import java.time.LocalDateTime;
import java.util.List;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.domain.Produto;

public class HistoricoPrecoService {
    public void adicionarEntradaHistorico(Produto produto, Double novoPrecoAquisicao, Double novoPrecoVenda) {
        HistoricoPreco novaEntrada = new HistoricoPreco(
            produto.getIdProduto(),
            LocalDateTime.now(),
            produto.getPrecoAquisicao(),
            produto.getPrecoVenda(),
            novoPrecoAquisicao,
            novoPrecoVenda
        );
        produto.getHistoricoPreco().add(novaEntrada);
    }

    public List<HistoricoPreco> obterHistoricoPreco(Produto produto) {
        return produto.getHistoricoPreco();
    }


	    public void imprimirDetalhesEHistorico(Produto produto) {
	        System.out.println(produto);
	        System.out.println("Histórico de Preço:");
	        obterHistoricoPreco(produto).forEach(System.out::println);
	        System.out.println("---------------------------------------------------");
	    }

}