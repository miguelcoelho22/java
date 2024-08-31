package alura.com.br.tabelafipedb;

import alura.com.br.tabelafipedb.principal.Principal;
import alura.com.br.tabelafipedb.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelafipedbApplication implements CommandLineRunner {
   	@Autowired
	CepRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(TabelafipedbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
