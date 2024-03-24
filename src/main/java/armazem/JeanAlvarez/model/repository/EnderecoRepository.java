package armazem.JeanAlvarez.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import armazem.JeanAlvarez.model.domain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,Integer> {

}
