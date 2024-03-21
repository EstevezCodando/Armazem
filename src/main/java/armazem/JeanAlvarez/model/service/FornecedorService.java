package armazem.JeanAlvarez.model.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import armazem.JeanAlvarez.model.domain.Fornecedor;

public class FornecedorService {
	private Map<String, Fornecedor> fornecedores = new HashMap<>();

    public void incluir(Fornecedor fornecedor) {
        fornecedores.put(fornecedor.getId(), fornecedor);
        System.out.println("Fornecedor " + fornecedor.getNome() + " incluído com sucesso.");
    }

    public Fornecedor obter(String idFornecedor) {
        return fornecedores.get(idFornecedor);
    }

    public Collection<Fornecedor> obterLista() {
        return fornecedores.values();
    }

    public void atualizar(String idFornecedor, Fornecedor dadosFornecedor) {
        if (fornecedores.containsKey(idFornecedor)) {
            fornecedores.put(idFornecedor, dadosFornecedor);
            System.out.println("Fornecedor " + dadosFornecedor.getNome() + " atualizado com sucesso.");
        } else {
            System.out.println("Fornecedor com ID " + idFornecedor + " não encontrado.");
        }
    }

    public void excluir(String idFornecedor) {
        if (fornecedores.remove(idFornecedor) != null) {
            System.out.println("Fornecedor com ID " + idFornecedor + " excluído com sucesso.");
        } else {
            System.out.println("Fornecedor com ID " + idFornecedor + " não encontrado.");
        }
    }

}
