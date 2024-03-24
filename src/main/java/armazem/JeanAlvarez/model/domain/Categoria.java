package armazem.JeanAlvarez.model.domain;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	@Transient
	private Categoria categoriaPai;
	
	public Categoria(Integer id, String nome, String descricao, Categoria categoriaPai) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaPai = categoriaPai;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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