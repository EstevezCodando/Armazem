package armazem.JeanAlvarez.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.Fornecedor;

@Service
public class FornecedorService {
	private Map<String, Fornecedor> fornecedores = new HashMap<>();

    public void incluir(Fornecedor fornecedor) {
        fornecedores.put(fornecedor.getId(), fornecedor);
    }

    public Fornecedor obter(String idFornecedor) {
        return fornecedores.get(idFornecedor);
    }

    public Collection<Fornecedor> obterLista() {
        return fornecedores.values();
    }

    public boolean atualizar(String idFornecedor, Fornecedor dadosFornecedor) {
        if (fornecedores.containsKey(idFornecedor)) {
            fornecedores.put(idFornecedor, dadosFornecedor);
            return true;
        }
        return false;
    }

    public boolean excluir(String idFornecedor) {
        return fornecedores.remove(idFornecedor) != null;
    }

}
