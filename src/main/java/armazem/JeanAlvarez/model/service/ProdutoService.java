package armazem.JeanAlvarez.model.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.domain.Produto;

public class ProdutoService {
	private Map<String, Produto> produtos = new HashMap<>();
	private HistoricoPrecoService historicoPrecoService;
	
	public ProdutoService(HistoricoPrecoService historicoPrecoService) {
		this.historicoPrecoService = historicoPrecoService;
	}
	public void incluir(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
        
        // Criação do histórico inicial para o produto
        HistoricoPreco historicoPreco = new HistoricoPreco(
            produto.getIdProduto(),
            LocalDateTime.now(),
            0.0, // Preço aquisição antigo
            0.0, // Preço venda antigo
            produto.getPrecoAquisicao(),
            produto.getPrecoVenda()
        );
        historicoPrecoService.incluir(historicoPreco);
    }
	
	  public Produto obter(String idProduto) {
	        return produtos.get(idProduto);
	    }
	
	  public void alterarPrecoAquisicao(String idProduto, Double novoPrecoAquisicao) {
	        Produto produto = produtos.get(idProduto);
	        if (produto != null) {
	            Double precoAntigo = produto.getPrecoAquisicao();
	            produto.setPrecoAquisicao(novoPrecoAquisicao);

	            // Adicionar ao histórico de preços
	            historicoPrecoService.incluir(new HistoricoPreco(
	                idProduto,
	                LocalDateTime.now(),
	                precoAntigo,
	                produto.getPrecoVenda(), // Preço venda antigo
	                novoPrecoAquisicao,
	                produto.getPrecoVenda() // Preço venda atual
	            ));
	        }
	    }

	    public void alterarPrecoVenda(String idProduto, Double novoPrecoVenda) {
	        Produto produto = produtos.get(idProduto);
	        if (produto != null) {
	            Double precoAntigo = produto.getPrecoVenda();
	            produto.setPrecoVenda(novoPrecoVenda);

	            // Adicionar ao histórico de preços
	            historicoPrecoService.incluir(new HistoricoPreco(
	                idProduto,
	                LocalDateTime.now(),
	                produto.getPrecoAquisicao(), // Preço aquisição atual
	                precoAntigo,
	                produto.getPrecoAquisicao(),
	                novoPrecoVenda
	            ));
	        }
	    }
	

}
