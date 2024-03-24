package armazem.JeanAlvarez.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Fornecedor;

@Service
public class FornecedorService {
	private Map<Integer, Fornecedor> fornecedores = new HashMap<>();
	
	@Autowired
    private LocalidadeService localidadeService;

    public void incluir(Fornecedor fornecedor) {
        if (fornecedor.getEndereco() != null && fornecedor.getEndereco().getCep() != null) {
            Endereco enderecoCompleto = localidadeService.obterPorCep(fornecedor.getEndereco().getCep());
            fornecedor.setEndereco(enderecoCompleto);
        }
        fornecedores.put(fornecedor.getId(), fornecedor);
    }
	

    public Fornecedor obter(Integer idFornecedor) {
        return fornecedores.get(idFornecedor);
    }

    public Collection<Fornecedor> obterLista() {
        return fornecedores.values();
    }

    public boolean atualizar(Integer idFornecedor, Fornecedor dadosFornecedor) {
        if (fornecedores.containsKey(idFornecedor)) {
            fornecedores.put(idFornecedor, dadosFornecedor);
            return true;
        }
        return false;
    }

    public boolean excluir(Integer idFornecedor) {
        return fornecedores.remove(idFornecedor) != null;
    }

}
