package armazem.JeanAlvarez.model.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.domain.Produto;
@Service
public class HistoricoPrecoService {
	private Map<Integer, HistoricoPreco> historicopreco = new HashMap<>();

	public void incluir(HistoricoPreco historicoPreco) {
		historicopreco.put(historicoPreco.getId(), historicoPreco);
	}

	public HistoricoPreco obterUltimoHistorico() {
		return historicopreco.values().stream().max(Comparator.comparingInt(HistoricoPreco::getId)).orElse(null);
	}

	public Collection<HistoricoPreco> obterLista() {
		return historicopreco.values();
	}
	
	public void imprimirDetalhesEHistorico(Produto produto) {
	    System.out.println(produto);
	    System.out.println("Histórico de Preço:");
	    for (HistoricoPreco hp : historicopreco.values()) {
	        if (hp.getIdProduto().equals(produto.getIdProduto())) {
	            System.out.println(hp);
	        }
	    }
	    System.out.println("---------------------------------------------------");
	}
}