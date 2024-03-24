package armazem.JeanAlvarez.model.domain;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class HistoricoPreco {
	 private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	 
	private Integer id;
	private Integer idProduto;
	private LocalDateTime dataAlteracao;
	private Double precoAquisicaoAntigo;
	private Double precoVendaAntigo;
	private Double precoAquisicaoAtual;
	private Double precoVendaAtual;
	
	public HistoricoPreco(Integer idProduto, LocalDateTime dataAlteracao, Double precoAquisicaoAntigo,
			Double precoVendaAntigo, Double precoAquisicaoAtual, Double precoVendaAtual) {
		this.id = ID_GENERATOR.incrementAndGet();
		this.idProduto = idProduto;
		this.dataAlteracao = dataAlteracao;
		this.precoAquisicaoAntigo = precoAquisicaoAntigo;
		this.precoVendaAntigo = precoVendaAntigo;
		this.precoAquisicaoAtual = precoAquisicaoAtual;
		this.precoVendaAtual = precoVendaAtual;
	}
	
	public int getId() {
		return id;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
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
		return "HistoricoPreco [id =" + id + ", idProduto=" + idProduto + ", dataAlteracao=" + dataAlteracao + ", precoAquisicaoAntigo="
				+ precoAquisicaoAntigo + ", precoVendaAntigo=" + precoVendaAntigo + ", precoAquisicaoAtual="
				+ precoAquisicaoAtual + ", precoVendaAtual=" + precoVendaAtual + "]";
	}
	
	
}
