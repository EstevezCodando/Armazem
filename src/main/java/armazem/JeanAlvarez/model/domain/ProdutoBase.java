package armazem.JeanAlvarez.model.domain;

public class ProdutoBase {
	private String idProduto;
	private String nome;
	private String marca;
	private String volume;
	private String descricao;
	private Categoria categoria;
	private String codigodeBarras;
	
	
	
	public ProdutoBase(String idProduto, String nome, String marca, String volume, String descricao,
			Categoria categoria, String codigodeBarras) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.marca = marca;
		this.volume = volume;
		this.descricao = descricao;
		this.categoria = categoria;
		this.codigodeBarras = codigodeBarras;
	}
	
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getCodigodeBarras() {
		return codigodeBarras;
	}
	public void setCodigodeBarras(String codigodeBarras) {
		this.codigodeBarras = codigodeBarras;
	}
	
	@Override
	public String toString() {
		return "ProdutoBase [idProduto=" + idProduto + ", nome=" + nome + ", marca=" + marca + ", volume=" + volume
				+ ", descricao=" + descricao + ", categoria=" + categoria + ", codigodeBarras=" + codigodeBarras + "]";
	}
	
}

