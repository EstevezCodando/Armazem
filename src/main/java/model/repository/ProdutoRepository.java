package model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByCategoriaNome(String nomeCategoria);
}
