package armazem.JeanAlvarez.model.domain;

import java.time.LocalDateTime;

public class HistoricoPreco {
	private String idProduto;
	private LocalDateTime dataAlteracao;
	private Double precoAquisicaoAntigo;
	private Double precoVendaAntigo;
	private Double precoAquisicaoAtual;
	private Double precoVendaAtual;
	
	public HistoricoPreco(String idProduto, LocalDateTime dataAlteracao, Double precoAquisicaoAntigo,
			Double precoVendaAntigo, Double precoAquisicaoAtual, Double precoVendaAtual) {
		super();
		this.idProduto = idProduto;
		this.dataAlteracao = dataAlteracao;
		this.precoAquisicaoAntigo = precoAquisicaoAntigo;
		this.precoVendaAntigo = precoVendaAntigo;
		this.precoAquisicaoAtual = precoAquisicaoAtual;
		this.precoVendaAtual = precoVendaAtual;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public Double getPrecoAquisicaoAntigo() {
		return precoAquisicaoAntigo;
	}
	public void setPrecoAquisicaoAntigo(Double precoAquisicaoAntigo) {
		this.precoAquisicaoAntigo = precoAquisicaoAntigo;
	}
	public Double getPrecoVendaAntigo() {
		return precoVendaAntigo;
	}
	public void setPrecoVendaAntigo(Double precoVendaAntigo) {
		this.precoVendaAntigo = precoVendaAntigo;
	}
	public Double getPrecoAquisicaoAtual() {
		return precoAquisicaoAtual;
	}
	public void setPrecoAquisicaoAtual(Double precoAquisicaoAtual) {
		this.precoAquisicaoAtual = precoAquisicaoAtual;
	}
	public Double getPrecoVendaAtual() {
		return precoVendaAtual;
	}
	public void setPrecoVendaAtual(Double precoVendaAtual) {
		this.precoVendaAtual = precoVendaAtual;
	}
	
	@Override
	public String toString() {
		return "HistoricoPreco [idProduto=" + idProduto + ", dataAlteracao=" + dataAlteracao + ", precoAquisicaoAntigo="
				+ precoAquisicaoAntigo + ", precoVendaAntigo=" + precoVendaAntigo + ", precoAquisicaoAtual="
				+ precoAquisicaoAtual + ", precoVendaAtual=" + precoVendaAtual + "]";
	}
	
	
}
