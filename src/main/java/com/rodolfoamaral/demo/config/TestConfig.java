package com.rodolfoamaral.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodolfoamaral.demo.entities.Pedido;
import com.rodolfoamaral.demo.entities.Usuario;
import com.rodolfoamaral.demo.repositories.RepositoryPedido;
import com.rodolfoamaral.demo.repositories.RepositoryUsuario;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired //associar uma instancia no config
	private RepositoryUsuario repoUsuario; //atributo de injeção de dependencia
	
	@Autowired
	private RepositoryPedido repoPedido;

	//EXECUTAR QUANDO O PROGRAMA FOR INICIADO (CommandLineRunner)
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Gordon Freeman", "DrFreeman@blackmesa.com", "988888888", "808080");
		Usuario u2 = new Usuario(null, "Agent 47", "a47@id.io", "977777777", "004700");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		repoUsuario.saveAll(Arrays.asList(u1, u2)); //saveAll passa uma lista de obj para salvar no banco
		repoPedido.saveAll(Arrays.asList(p1, p2, p3));
	}
	
}
