package armazem.JeanAlvarez.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armazem.JeanAlvarez.model.domain.HistoricoPreco;
import armazem.JeanAlvarez.model.service.HistoricoPrecoService;

@RestController
@RequestMapping("/api/historicodosprecos")
public class HistoricoPrecoController {
	
	@Autowired
    private HistoricoPrecoService historicoService;


	@GetMapping("/produto/{idProduto}")
    public HistoricoPreco obterUltimoHistoricoPorProdutoID(@PathVariable Integer idProduto) {
        return historicoService.obterUltimoHistoricoPorProdutoID(idProduto);
    }

    @GetMapping("/{id}")
    public HistoricoPreco obterHistoricoPorId(@PathVariable int id) {
        return historicoService.obterHistoricoPorId(id);
    }

    @GetMapping("/lista")
    public Collection<HistoricoPreco> obterLista() {
        return historicoService.obterLista();
    }

	

}
