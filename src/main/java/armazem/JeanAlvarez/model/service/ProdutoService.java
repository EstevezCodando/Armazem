package armazem.JeanAlvarez.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.domain.Produto;

@Service
public class ProdutoService {
	private Map<Integer, Produto> produtos = new HashMap<>();
	private HistoricoPrecoService historicoPrecoService;

	public ProdutoService(HistoricoPrecoService historicoPrecoService) {
		this.historicoPrecoService = historicoPrecoService;
	}

	public void incluir(Produto produto) {
		produtos.put(produto.getIdProduto(), produto);
		historicoPrecoService.incluir(new HistoricoPreco(produto.getIdProduto(), LocalDateTime.now(), 0.0, 0.0,
				produto.getPrecoAquisicao(), produto.getPrecoVenda()));
	}

	public boolean alterarPrecoAquisicao(Integer idProduto, Double novoPrecoAquisicao) {
	    Produto produto = produtos.get(idProduto);
	    if (produto != null) {
	        Double precoAntigo = produto.getPrecoAquisicao();
	        produto.setPrecoAquisicao(novoPrecoAquisicao);
	        produtos.put(idProduto, produto); 
	        historicoPrecoService.incluir(new HistoricoPreco(idProduto, LocalDateTime.now(), precoAntigo,
	                produto.getPrecoVenda(), novoPrecoAquisicao, produto.getPrecoVenda()));
	        return true;
	    }
	    return false;
	}


	public boolean alterarPrecoVenda(Integer idProduto, Double novoPrecoVenda) {
	    Produto produto = produtos.get(idProduto);
	    if (produto != null) {
	        Double precoAntigo = produto.getPrecoVenda();
	        produto.setPrecoVenda(novoPrecoVenda);
	        produtos.put(idProduto, produto); 
	        historicoPrecoService.incluir(new HistoricoPreco(idProduto, LocalDateTime.now(),
	                produto.getPrecoAquisicao(), precoAntigo, produto.getPrecoAquisicao(), novoPrecoVenda));
	        return true;
	    }
	    return false;
	}


	public Produto obter(Integer idProduto) {
		return produtos.get(idProduto);
	}

	public boolean excluir(Integer idProduto) {
		return produtos.remove(idProduto) != null;
	}

	public Collection<Produto> obterLista() {
		return produtos.values();
	}

	public boolean atualizar(Integer idProduto, Produto dadosProduto) {
		if (produtos.containsKey(idProduto)) {
			produtos.put(idProduto, dadosProduto);
			return true;
		}
		return false;
	}

}
