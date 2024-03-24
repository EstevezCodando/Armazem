package armazem.JeanAlvarez.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Produto extends ProdutoBase {

    private Double precoAquisicao;
    private Double precoVenda;
    private int quantidadeEstoque;
    private List<Fornecedor> fornecedores;
    private List<HistoricoPreco> historicoPreco;

    public Produto(Integer idProduto, String nome, String marca, String volume, String descricao, Categoria categoria,
                   String codigodeBarras, Double precoAquisicao, Double precoVenda, int quantidadeEstoque,
                   List<Fornecedor> fornecedores, List<HistoricoPreco> historicoPreco)
    {
        super(idProduto, nome, marca, volume, descricao, categoria, codigodeBarras);
        this.precoAquisicao = precoAquisicao;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedores = fornecedores;
        this.historicoPreco = historicoPreco;
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
	
	public void adicionarHistoricoPreco(HistoricoPreco historicoPreco) {
        if (this.historicoPreco == null) {
            this.historicoPreco = new ArrayList<>();
        }
        this.historicoPreco.add(historicoPreco);
    }
    
	 @Override
	    public String toString() {
	        return "Produto [precoAquisicao=" + precoAquisicao + ", precoVenda=" + precoVenda + ", quantidadeEstoque="
	                + quantidadeEstoque + ", fornecedores=" + fornecedores + ", historicoPreco=" + historicoPreco + "]";
	    }
}