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
	private ILocalidadeClient localidadeClient;
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco obterPorCep( String cep) {
		return enderecoClient.obterPorCep(cep);
	}
	
	public Collection<Estado> obterEstados(){
		return localidadeClient.obterEstados();
	}

	public Collection<Municipio> obterMunicipioPorUF( Integer ID_SiglaUF){
		return localidadeClient.obterMunicipioPorUF(ID_SiglaUF); 
	}
	

	public Collection<Distrito> obterDistritoPorMunicipio( Integer ID_Municipio){
		return localidadeClient.obterDistritoPorMunicipio(ID_Municipio);
	}

}
