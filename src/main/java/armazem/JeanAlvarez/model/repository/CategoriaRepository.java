package armazem.JeanAlvarez.model.repository;

import org.springframework.data.repository.CrudRepository;

import armazem.JeanAlvarez.model.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {

}
