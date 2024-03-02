package model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.domain.Categoria;

import java.util.Optional;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
    Optional<Categoria> findByNome(String nome);
    List<Categoria> findByCategoriaPaiId(String categoriaPaiId);
}
