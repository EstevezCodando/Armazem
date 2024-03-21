package armazem.JeanAlvarez.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import armazem.JeanAlvarez.model.domain.Produto;

public class ProdutoService {
    
    private Map<String, Produto> produtos = new HashMap<>();
    private HistoricoPrecoService historicoPrecoService = new HistoricoPrecoService();

    // Incluir produto
    public void incluir(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
        System.out.println("A inclusão do produto " + produto.getNome() + " foi realizada com sucesso.");
    }

    // Excluir produto
    public void excluir(String idProduto) {
        Produto produto = produtos.remove(idProduto);
        if (produto != null) {
            System.out.println("A exclusão do produto " + produto.getNome() + " foi realizada com sucesso.");
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado.");
        }
    }

    // Obter lista de produtos
    public Collection<Produto> obterLista() {
        return produtos.values();
    }

    // Obter um produto específico
    public Produto obter(String idProduto) {
        return produtos.get(idProduto);
    }

    // Alterar produto
    public void alterar(String idProduto, Double novoPrecoAquisicao, Double novoPrecoVenda, int novaQuantidadeEstoque) {
        Produto produto = produtos.get(idProduto);
        if (produto != null) {
            produto.setPrecoAquisicao(novoPrecoAquisicao);
            produto.setPrecoVenda(novoPrecoVenda);
            produto.setQuantidadeEstoque(novaQuantidadeEstoque);
            historicoPrecoService.adicionarEntradaHistorico(produto, novoPrecoAquisicao, novoPrecoVenda);
            System.out.println("Produto " + produto.getNome() + " atualizado com sucesso.");
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado para atualização.");
        }
    }
}