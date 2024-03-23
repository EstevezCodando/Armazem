package armazem.JeanAlvarez.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armazem.JeanAlvarez.model.domain.Fornecedor;
import armazem.JeanAlvarez.model.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
	
	@Autowired
    private FornecedorService fornecedorService;

    @PostMapping(value="/incluir")
    public String incluir(Fornecedor fornecedor) {
        fornecedorService.incluir(fornecedor);
        return "Fornecedor " + fornecedor.getNome() + " incluído com sucesso.";
    }
    
    @DeleteMapping(value="/excluir/{idFornecedor}")
    public String excluir(@PathVariable String idFornecedor) {
        boolean excluido = fornecedorService.excluir(idFornecedor);
        if (excluido) {
            return "Fornecedor com ID " + idFornecedor + " excluído com sucesso.";
        } else {
            return "Fornecedor com ID " + idFornecedor + " não encontrado.";
        }
    }

    @GetMapping(value= "/{idFornecedor}/obter")
    public Fornecedor obter(@PathVariable String idFornecedor) {
        return fornecedorService.obter(idFornecedor);
    }

    @GetMapping(value = "/lista")
    public Collection<Fornecedor> obterLista() {
        return fornecedorService.obterLista();
    }

    @PostMapping(value="/atualizar/{idFornecedor}")
    public String atualizar(@PathVariable String idFornecedor, Fornecedor dadosFornecedor) {
        boolean atualizado = fornecedorService.atualizar(idFornecedor, dadosFornecedor);
        if (atualizado) {
            return "Fornecedor " + dadosFornecedor.getNome() + " atualizado com sucesso.";
        } else {
            return "Fornecedor com ID " + idFornecedor + " não encontrado.";
        }
    }

	

}
