/*ESSA CLASSE VAI DISPONIBILIZAR O RECURSO WEB REFERENTE A ENTIDADE USUÁRIO*/

package com.rodolfoamaral.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.demo.entities.Usuario;
import com.rodolfoamaral.demo.services.ServicesUsuario;

@RestController //indicar que essa classe é um recurso web
@RequestMapping(value = "/usuarios")
public class ResourceUsuario {
	
	@Autowired //injetar o service do usuario automaticamente
	private ServicesUsuario servico;  //dependencia para o serviceUsuario
	
	@GetMapping //responde a requisição do tipo "get"
	public ResponseEntity<List<Usuario>> localizarTodos(){ //retornar respostas de requisições web
		List<Usuario> lista = servico.localizaTodos();
		return ResponseEntity.ok().body(lista); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> localizarID(@PathVariable Long id){
		Usuario obj = servico.localizarID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
