package armazem.JeanAlvarez.model.domain;

public class Categoria {
	private String id;
	private String nome;
	private String descricao;
	private Categoria categoriaPai;
	
	public Categoria(String id, String nome, String descricao, Categoria categoriaPai) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaPai = categoriaPai;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}


	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	@Override
	 public String toString() {
        String categoriaPaiNome = (categoriaPai != null) ? categoriaPai.getNome() : "Nenhuma";
        return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoriaPai=" + categoriaPaiNome + "]";
	}
}