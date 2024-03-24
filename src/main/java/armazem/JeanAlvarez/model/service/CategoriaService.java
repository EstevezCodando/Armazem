package armazem.JeanAlvarez.model.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.Categoria;

@Service
public class CategoriaService {
    private Map<Integer, Categoria> categorias = new HashMap<>();

    // Incluir categoria
    public void incluir(Categoria categoria) {
        categorias.put(categoria.getId(), categoria);
    }

    // Obter uma categoria pelo ID
    public Categoria obter(Integer id) {
        return categorias.get(id);
    }

    // Obter a lista de categorias
    public Collection<Categoria> obterLista() {
        return categorias.values();
    }

    
    public boolean atualizar(Integer id, Categoria dadosCategoria) {
        if (categorias.containsKey(id)) {
        	categorias.put(id, dadosCategoria);
            return true;
        }
        return false;
    }

    
    public boolean excluir(Integer id) {
        return categorias.remove(id) != null;
    }
}
