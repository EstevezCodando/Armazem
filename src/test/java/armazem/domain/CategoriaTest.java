package armazem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.domain.Categoria;


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
	
	@Test
	void alterarAtributosCategoria() {
	
	    Categoria refrigerantes = new Categoria("0003", "Refrigerantes", "Bebidas gaseificadas", bebidas);
	    
	
	    refrigerantes.setNome("Soft Drinks");
	    refrigerantes.setDescricao("Bebidas gaseificadas sem álcool");
	    Categoria sucos = new Categoria("0004", "Sucos", "Bebidas naturais de frutas", null);
	    refrigerantes.setCategoriaPai(sucos);
	    
	
	    assertEquals("Soft Drinks", refrigerantes.getNome());
	    assertEquals("Bebidas gaseificadas sem álcool", refrigerantes.getDescricao());
	    assertEquals(sucos, refrigerantes.getCategoriaPai());
	    assertEquals("Sucos", refrigerantes.getCategoriaPai().getNome());
	}


}
