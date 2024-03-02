package model.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Produto extends ProdutoBase {

    private Double precoAquisicao;
    private Double PrecoVenda;
    private int quantidadeEstoque;
    private Map<LocalDateTime, HistoricoPreco> historicoPreco = new HashMap<>();

    public Produto(String idProduto, String nome, String marca, String volume, String descricao, Categoria categoria, String codigodeBarras) {
        super(idProduto, nome, marca, volume, descricao, categoria, codigodeBarras);
    }

    public Double getPrecoAquisicao() {
        return precoAquisicao;
    }

    public void setPrecoAquisicao(Double precoAquisicao) {
        this.precoAquisicao = precoAquisicao;
    }

    public Double getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        PrecoVenda = precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Map<LocalDateTime, HistoricoPreco> getHistoricoPreco() {
        return historicoPreco;
    }

    public void setHistoricoPreco(Map<LocalDateTime, HistoricoPreco> historicoPreco) {
        this.historicoPreco = historicoPreco;
    }
}
