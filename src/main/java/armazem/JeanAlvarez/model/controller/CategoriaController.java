package armazem.JeanAlvarez.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armazem.JeanAlvarez.model.domain.Categoria;
import armazem.JeanAlvarez.model.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;

    @PostMapping(value="/incluir")
    public String incluir(@RequestBody Categoria categoria) {
    	categoriaService.incluir(categoria);
        return "Categoria " + categoria.getNome() + " incluído com sucesso.";
    }
    
    @DeleteMapping(value="/excluir/{idFornecedor}")
    public String excluir(@PathVariable Integer id) {
        boolean excluido = categoriaService.excluir(id);
        if (excluido) {
            return "Categoria com ID " + id + " excluído com sucesso.";
        } else {
            return "Categoria com ID " + id + " não encontrado.";
        }
    }

    @GetMapping(value= "/obterPorID/{idFornecedor}")
    public Categoria obter(@PathVariable Integer id) {
        return categoriaService.obter(id);
    }

    @GetMapping(value = "/lista")
    public Collection<Categoria> obterLista() {
        return categoriaService.obterLista();
    }

    @PostMapping(value="/atualizar/{idFornecedor}")
    public String atualizar(@PathVariable Integer id, Categoria dadosCategoria) {
        boolean atualizado = categoriaService.atualizar(id, dadosCategoria);
        if (atualizado) {
            return "Categoria " + dadosCategoria.getNome() + " atualizado com sucesso.";
        } else {
            return "Categoria com ID " + id + " não encontrado.";
        }
    }

	

}
