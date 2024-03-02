package model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.domain.Categoria;
import model.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria adicionarCategoria(Categoria categoria) {

        Optional<Categoria> categoriaExistente = categoriaRepository.findByNome(categoria.getNome());
        if(categoriaExistente.isPresent()) {
            throw new RuntimeException("Categoria já existe.");
        }
        return categoriaRepository.save(categoria);
    }


    public void removerCategoria(String id) {
        if(!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada.");
        }
        categoriaRepository.deleteById(id);
    }


    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }


    public List<Categoria> listarCategoriasFilhas(String idCategoriaPai) {
        return categoriaRepository.findByCategoriaPaiId(idCategoriaPai);
    }
}
