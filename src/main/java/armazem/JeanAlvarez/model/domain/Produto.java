package armazem.JeanAlvarez.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Produto extends ProdutoBase {

    private Double precoAquisicao;
    private Double precoVenda;
    private int quantidadeEstoque;
    private List<Fornecedor> fornecedores;
    private List<HistoricoPreco> historicoPreco = new ArrayList<>();

    public Produto(String idProduto, String nome, String marca, String volume, String descricao, Categoria categoria,
                   String codigodeBarras, Double precoAquisicao, Double precoVenda, int quantidadeEstoque,
                   List<Fornecedor> fornecedores) {
        super(idProduto, nome, marca, volume, descricao, categoria, codigodeBarras);
        this.precoAquisicao = precoAquisicao;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedores = fornecedores;
        this.historicoPreco.add(new HistoricoPreco(idProduto, LocalDateTime.now(), 0.0, 0.0, precoAquisicao, precoVenda));
    }

    public void atualizarPrecoAquisicao(Double novoPreco) {
        HistoricoPreco hp = new HistoricoPreco(getIdProduto(), LocalDateTime.now(), this.precoAquisicao, this.precoVenda, novoPreco, this.precoVenda);
        this.historicoPreco.add(hp);
        this.precoAquisicao = novoPreco;
    }

    public void atualizarPrecoVenda(Double novoPreco) {
        HistoricoPreco hp = new HistoricoPreco(getIdProduto(), LocalDateTime.now(), this.precoAquisicao, this.precoVenda, this.precoAquisicao, novoPreco);
        this.historicoPreco.add(hp);
        this.precoVenda = novoPreco;
    }

	public Double getPrecoAquisicao() {
		return precoAquisicao;
	}

	public void setPrecoAquisicao(Double precoAquisicao) {
		this.precoAquisicao = precoAquisicao;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<HistoricoPreco> getHistoricoPreco() {
		return historicoPreco;
	}

	public void setHistoricoPreco(List<HistoricoPreco> historicoPreco) {
		this.historicoPreco = historicoPreco;
	}
    
	 @Override
	    public String toString() {
	        return "Produto [precoAquisicao=" + precoAquisicao + ", precoVenda=" + precoVenda + ", quantidadeEstoque="
	                + quantidadeEstoque + ", fornecedores=" + fornecedores + ", historicoPreco=" + historicoPreco + "]";
	    }
}