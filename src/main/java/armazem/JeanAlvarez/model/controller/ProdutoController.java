package armazem.JeanAlvarez.model.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armazem.JeanAlvarez.model.domain.Produto;
import armazem.JeanAlvarez.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    //Metodo alternativo usando o responseentity, nao cria o caminho incluir, faz a magia igual
    @PostMapping
    public ResponseEntity<String> incluir(@RequestBody Produto produto) {
        produtoService.incluir(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto " + produto.getNome() + " incluído com sucesso.");
    }

    @DeleteMapping(value="/excluir/{idProduto}")
    public String excluir(@PathVariable Integer idProduto) {
        Produto produto = produtoService.obter(idProduto);
        if (produto != null) {
            produtoService.excluir(idProduto);
            return "Produto com ID " + idProduto + " excluído com sucesso.";
        } else {
            return "Produto com ID " + idProduto + " não encontrado.";
        }
    }

    @GetMapping(value="/obterPorID/{idProduto}")
    public Produto obter(@PathVariable Integer idProduto) {
        return produtoService.obter(idProduto);
    }

    @GetMapping(value="/lista")
    public Collection<Produto> obterLista() {
        return produtoService.obterLista();
    }

    @PostMapping(value="/atualizar/{idProduto}")
    public String atualizar(@PathVariable Integer idProduto, @RequestBody Produto dadosProduto) {
        Produto produto = produtoService.obter(idProduto);
        if (produto != null) {
            produtoService.atualizar(idProduto, dadosProduto);
            return "Produto " + dadosProduto.getNome() + " atualizado com sucesso.";
        } else {
            return "Produto com ID " + idProduto + " não encontrado.";
        }
    }

    
    @PutMapping("/{idProduto}/novoPrecoAquisicao")
    public ResponseEntity<String> alterarPrecoAquisicao(@PathVariable Integer idProduto, @RequestBody Map<String, Double> body) {
        Double novoPrecoAquisicao = body.get("novoPrecoAquisicao");
        if (produtoService.alterarPrecoVenda(idProduto, novoPrecoAquisicao)) {
            return ResponseEntity.ok("Preço de Aquiscao do produto com ID " + idProduto + " alterado para " + novoPrecoAquisicao + ".");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idProduto}/precoVenda")
    public ResponseEntity<String> alterarPrecoVenda(@PathVariable Integer idProduto, @RequestBody Map<String, Double> body) {
        Double novoPrecoVenda = body.get("novoPrecoVenda");
        if (produtoService.alterarPrecoVenda(idProduto, novoPrecoVenda)) {
            return ResponseEntity.ok("Preço de venda do produto com ID " + idProduto + " alterado para " + novoPrecoVenda + ".");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
