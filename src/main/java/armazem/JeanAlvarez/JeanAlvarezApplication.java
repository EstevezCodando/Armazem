package armazem.JeanAlvarez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients(basePackages = "armazem.JeanAlvarez.model.clients")
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
public class JeanAlvarezApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeanAlvarezApplication.class, args);
	}

}
