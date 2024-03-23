package armazem.JeanAlvarez.model.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.domain.Categoria;

@Service
public class CategoriaService {
    private Map<String, Categoria> categorias = new HashMap<>();

    // Incluir categoria
    public void incluir(Categoria categoria) {
        categorias.put(categoria.getId(), categoria);
    }

    // Obter uma categoria pelo ID
    public Categoria obter(String id) {
        return categorias.get(id);
    }

    // Obter a lista de categorias
    public Collection<Categoria> obterLista() {
        return categorias.values();
    }

    // Atualizar categoria
    public void atualizar(String id, Categoria novosDados) {
        Categoria categoria = categorias.get(id);
        if (categoria != null) {
            categoria.setNome(novosDados.getNome());
            categoria.setDescricao(novosDados.getDescricao());
            categoria.setCategoriaPai(novosDados.getCategoriaPai());
            categorias.put(id, categoria); // atualiza a categoria no mapa
            System.out.println("Categoria " + categoria.getNome() + " atualizada com sucesso.");
        } else {
            System.out.println("Categoria com ID " + id + " não encontrada.");
        }
    }

    // Excluir categoria
    public void excluir(String id) {
        Categoria removida = categorias.remove(id);
        if (removida != null) {
            System.out.println("Categoria com ID " + id + " excluída com sucesso.");
        } else {
            System.out.println("Categoria com ID " + id + " não encontrada.");
        }
    }
}
