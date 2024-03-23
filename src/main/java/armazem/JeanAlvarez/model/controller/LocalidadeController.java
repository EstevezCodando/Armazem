package armazem.JeanAlvarez.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import armazem.JeanAlvarez.model.domain.Distrito;
import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Estado;
import armazem.JeanAlvarez.model.domain.Municipio;
import armazem.JeanAlvarez.model.service.LocalidadeService;

@RestController
@RequestMapping("/api/localidade")
public class LocalidadeController {
	
	
	@Autowired
	private LocalidadeService localidadeService;
	
	@GetMapping(value = "/{cep}")
	public Endereco obterPorCep(@PathVariable String cep) {
		return localidadeService.obterPorCep(cep);
	}
	
	@GetMapping(value = "/estados")
	public Collection<Estado> obterEstados(){
		return localidadeService.obterEstados();
	}
	
	@GetMapping(value = "/{ID_SiglaUF}/municipios")
	public Collection<Municipio> obterMunicipioPorUF(@PathVariable Integer ID_SiglaUF){
		return localidadeService.obterMunicipioPorUF(ID_SiglaUF); 
	}
	
	@GetMapping(value = "/{ID_Municipio}/distritos")
	public Collection<Distrito> obterDistritoPorMunicipio(@PathVariable Integer ID_Municipio){
		return localidadeService.obterDistritoPorMunicipio(ID_Municipio);
	}

}
