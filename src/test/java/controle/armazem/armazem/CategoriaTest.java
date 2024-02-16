package controle.armazem.armazem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import model.domain.Categoria;

@SpringBootTest
class CategoriaTest {
	
	private Categoria bebidas; 
	private final String ID = "0001";
	private final String NOME = "Bebidas";
	private final String DESCRICAO = "Liquido para consumo humano";
	private Categoria alcoolicas;
	
	@BeforeEach
	void setUp() {
		bebidas = new Categoria(null,null,null,null);
		bebidas.setId(ID);
		bebidas.setNome(NOME);
		bebidas.setDescricao(DESCRICAO);
		bebidas.setCategoriaPai(null);
		alcoolicas = new Categoria("0002", "Alcoólicas", "As bebidas alcoólicas são bebidas que contêm etanol em sua composição", bebidas);

	}
	
	@Test
	void categoriaComUmaCategoriaPai() {
		assertEquals("Bebidas", alcoolicas.getCategoriaPai().getNome());
	}
	@Test
	void printCategoriaComPai() {
	    String expected = "Categoria [id=0002, nome=Alcoólicas, descricao=As bebidas alcoólicas são bebidas que contêm etanol em sua composição, categoriaPai=Bebidas]";
	    assertEquals(expected, alcoolicas.toString());
	}
	@Test
	void printCategoriaSemPai() {
	    String expected = "Categoria [id=0001, nome=Bebidas, descricao=Liquido para consumo humano, categoriaPai=Nenhuma]";
	    assertEquals(expected, bebidas.toString());
	}
	
	@Test
	void recuperarDados() {
		assertEquals(ID,bebidas.getId());
		assertEquals(NOME,bebidas.getNome());
		assertEquals(DESCRICAO,bebidas.getDescricao());
		
	}

}
