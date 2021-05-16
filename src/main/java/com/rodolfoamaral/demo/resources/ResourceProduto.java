/*ESSA CLASSE VAI DISPONIBILIZAR O RECURSO WEB REFERENTE A ENTIDADE USUÁRIO*/

package com.rodolfoamaral.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.demo.entities.Produto;
import com.rodolfoamaral.demo.services.ServicesProduto;

@RestController //indicar que essa classe é um recurso web
@RequestMapping(value = "/produtos")
public class ResourceProduto {
	
	@Autowired //injetar o service do usuario automaticamente
	private ServicesProduto servico;  //dependencia para o serviceProduto
	
	@GetMapping //responde a requisição do tipo "get"
	public ResponseEntity<List<Produto>> localizarTodos(){ //retornar respostas de requisições web
		List<Produto> lista = servico.localizaTodos();
		return ResponseEntity.ok().body(lista); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> localizarID(@PathVariable Long id){
		Produto obj = servico.localizarID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
