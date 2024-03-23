package armazem.JeanAlvarez.model.clients;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import armazem.JeanAlvarez.model.domain.Distrito;
import armazem.JeanAlvarez.model.domain.Estado;
import armazem.JeanAlvarez.model.domain.Municipio;


// https://viacep.com.br/ws

@FeignClient(url = "http://servicodados.ibge.gov.br/api/v1/localidades", name="LocalidadeClient")

public interface ILocalidadeClient {
	//@GetMapping(value = "/{cep}/json/")
	//Endereco obterPorCep(@PathVariable String cep);
	
	//Consigo todos os estados apartir de agora 
	@GetMapping(value = "/estados?orderBy=nome")
	Collection<Estado> obterEstados();
	
	@GetMapping(value = "/estados//{ID_SiglaUF}/municipios")
	Collection<Municipio> obterMunicipioPorUF(@PathVariable Integer ID_SiglaUF);
	
	@GetMapping(value = "/municipios/{ID_Municipio}/distritos")
	Collection<Distrito> obterDistritoPorMunicipio(@PathVariable Integer ID_Municipio);
	
	// /estados?orderBy=nome
	// /3550308/distritos
	// /33/municipios
	
	
}
