package com.rodolfoamaral.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodolfoamaral.demo.entities.Usuario;
import com.rodolfoamaral.demo.repositories.RepositoryUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired //associar uma instancia no config
	private RepositoryUsuario repoUsuario; //atributo de injeção de dependencia

	//EXECUTAR QUANDO O PROGRAMA FOR INICIADO (CommandLineRunner)
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Gordon Freeman", "DrFreeman@blackmesa.com", "988888888", "808080");
		Usuario u2 = new Usuario(null, "Agent 47", "a47@id.io", "977777777", "004700");
		
		repoUsuario.saveAll(Arrays.asList(u1, u2)); 
		//saveAll passa uma lista de obj para salvar no banco
	}
	
}
