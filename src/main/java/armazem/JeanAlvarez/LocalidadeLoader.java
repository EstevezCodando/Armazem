package armazem.JeanAlvarez;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import armazem.JeanAlvarez.model.clients.ILocalidadeClient;
import armazem.JeanAlvarez.model.domain.Estado;
import armazem.JeanAlvarez.model.domain.Municipio;

@Component
public class LocalidadeLoader implements ApplicationRunner {

	@Autowired

	private ILocalidadeClient LocalidadeClient;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Collection<Estado> estados =  LocalidadeClient.obterEstados();
		System.out.println("------------ AQUI ---------- " );
		for (Estado estado: estados) {
			System.out.println("- ESTADO: " + estado.getNome());
			Collection<Municipio> municipios = LocalidadeClient.obterMunicipioPorUF(estado.getId());
			for (Municipio municipio : municipios) {
				System.out.println("---Municipio: " + municipio.getNome());
			}
			
	
		}
		System.out.println("---- ---------------");
	}

}
