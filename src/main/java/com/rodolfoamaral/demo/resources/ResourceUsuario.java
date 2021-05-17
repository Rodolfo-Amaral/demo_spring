/*ESSA CLASSE VAI DISPONIBILIZAR O RECURSO WEB REFERENTE A ENTIDADE USUÁRIO*/

package com.rodolfoamaral.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		obj = servico.inserirUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario obj) {
		obj = servico.atualizarUsuario(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
