package armazem.JeanAlvarez.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.domain.Produto;

@Service
public class HistoricoPrecoService {
	private Map<Integer, List<HistoricoPreco>> historicopreco = new HashMap<>();

    public void incluir(HistoricoPreco historicoPreco) {
        List<HistoricoPreco> historicos = historicopreco.computeIfAbsent(historicoPreco.getIdProduto(), k -> new ArrayList<>());
        historicos.add(historicoPreco);
    }

    public HistoricoPreco obterHistoricoPorId(int id) {
        for (List<HistoricoPreco> historicos : historicopreco.values()) {
            for (HistoricoPreco hp : historicos) {
                if (hp.getId()== id) {
                    return hp;
                }
            }
        }
        return null;
    }

    public Collection<HistoricoPreco> obterLista() {
        return historicopreco.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public HistoricoPreco obterUltimoHistoricoPorProdutoID(Integer idProduto) {
        return historicopreco.getOrDefault(idProduto, new ArrayList<>()).stream()
                .max(Comparator.comparing(HistoricoPreco::getDataAlteracao)).orElse(null);
    }

    public void imprimirDetalhesEHistorico(Produto produto) {
        System.out.println(produto);
        System.out.println("Histórico de Preço:");
        List<HistoricoPreco> historicos = historicopreco.getOrDefault(produto.getIdProduto(), new ArrayList<>());
        historicos.forEach(System.out::println);
        System.out.println("---------------------------------------------------");
    }
}