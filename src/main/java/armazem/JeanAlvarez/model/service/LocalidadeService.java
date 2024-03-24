package armazem.JeanAlvarez.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import armazem.JeanAlvarez.model.clients.IEnderecoClient;
import armazem.JeanAlvarez.model.clients.ILocalidadeClient;
import armazem.JeanAlvarez.model.domain.Distrito;
import armazem.JeanAlvarez.model.domain.Endereco;
import armazem.JeanAlvarez.model.domain.Estado;
import armazem.JeanAlvarez.model.domain.Municipio;

@Service
public class LocalidadeService {
	
	@Autowired
	private ILocalidadeClient localidadeService;
	@Autowired
	private IEnderecoClient enderecoService;

	public Endereco obterPorCep( String cep) {
		return enderecoService.obterPorCep(cep);
	}
	
	public Collection<Estado> obterEstados(){
		return localidadeService.obterEstados();
	}

	public Collection<Municipio> obterMunicipioPorUF( Integer ID_SiglaUF){
		return localidadeService.obterMunicipioPorUF(ID_SiglaUF); 
	}
	

	public Collection<Distrito> obterDistritoPorMunicipio( Integer ID_Municipio){
		return localidadeService.obterDistritoPorMunicipio(ID_Municipio);
	}

}
