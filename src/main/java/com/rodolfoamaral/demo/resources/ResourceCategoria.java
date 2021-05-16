/*ESSA CLASSE VAI DISPONIBILIZAR O RECURSO WEB REFERENTE A ENTIDADE USUÁRIO*/

package com.rodolfoamaral.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.demo.entities.Categoria;
import com.rodolfoamaral.demo.services.ServicesCategoria;

@RestController //indicar que essa classe é um recurso web
@RequestMapping(value = "/categorias")
public class ResourceCategoria {
	
	@Autowired //injetar o service do usuario automaticamente
	private ServicesCategoria servico;  //dependencia para o serviceCategoria
	
	@GetMapping //responde a requisição do tipo "get"
	public ResponseEntity<List<Categoria>> localizarTodos(){ //retornar respostas de requisições web
		List<Categoria> lista = servico.localizaTodos();
		return ResponseEntity.ok().body(lista); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> localizarID(@PathVariable Long id){
		Categoria obj = servico.localizarID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
