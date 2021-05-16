/*ESSA CLASSE VAI DISPONIBILIZAR O RECURSO WEB REFERENTE A ENTIDADE USUÁRIO*/

package com.rodolfoamaral.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.demo.entities.Usuario;

@RestController //indicar que essa classe é um recurso web
@RequestMapping(value = "/usuarios")
public class ResourceUsuario {
	
	@GetMapping //responde a requisição do tipo "get"
	public ResponseEntity<Usuario> localizarTodos(){ //retornar respostas de requisições web
		Usuario u = new Usuario(1L, "Mario", "supermario@yahoo.com", "9999999", "123456");
		return ResponseEntity.ok().body(u); //retornar a resposta
		
	}

}
