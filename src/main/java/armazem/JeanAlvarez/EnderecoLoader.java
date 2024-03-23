package armazem.JeanAlvarez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import armazem.JeanAlvarez.model.clients.IEnderecoClient;
import armazem.JeanAlvarez.model.domain.Endereco;

@Component
public class EnderecoLoader implements ApplicationRunner {

	@Autowired

	private IEnderecoClient enderecoClient;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Endereco EnderecoViaCep = enderecoClient.obterPorCep("20010020");
		System.out.println("------------ AQUI ---------- ");
		System.out.println("---- " + EnderecoViaCep);

	}

}
