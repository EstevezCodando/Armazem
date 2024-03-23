package armazem.JeanAlvarez.model.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import armazem.JeanAlvarez.model.domain.Endereco;


// https://viacep.com.br/ws

@FeignClient(url = "https://viacep.com.br/ws", name="EnderecoClient")

public interface ILocalizacaoClient {
	@GetMapping(value = "/{cep}/json/")
	// /01001000/json/
	
	Endereco obterPorCep(@PathVariable String cep);

}
