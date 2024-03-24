package armazem.JeanAlvarez.model.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import armazem.JeanAlvarez.model.domain.Endereco;



@FeignClient(url = "https://viacep.com.br/ws", name="EnderecoClient")

public interface IEnderecoClient {
	@GetMapping(value = "/{cep}/json/")
	
	Endereco obterPorCep(@PathVariable String cep);
 
}
