package Primeiro.projeto.Spring.sem.web;

import Primeiro.projeto.Spring.sem.web.model.DadosSerie;
import Primeiro.projeto.Spring.sem.web.service.ConsumoAPI;
import Primeiro.projeto.Spring.sem.web.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoapi = new ConsumoAPI();
		var json = consumoapi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=b2d3f53c");
		System.out.println(json);
		var converte = new ConverteDados();
		DadosSerie dados = converte.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
