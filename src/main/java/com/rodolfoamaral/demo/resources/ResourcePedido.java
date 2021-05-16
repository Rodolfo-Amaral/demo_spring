/*ESSA CLASSE VAI DISPONIBILIZAR O RECURSO WEB REFERENTE A ENTIDADE USUÁRIO*/

package com.rodolfoamaral.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolfoamaral.demo.entities.Pedido;
import com.rodolfoamaral.demo.services.ServicesPedidos;

@RestController //indicar que essa classe é um recurso web
@RequestMapping(value = "/pedidos")
public class ResourcePedido {
	
	@Autowired //injetar o service do usuario automaticamente
	private ServicesPedidos servico;  //dependencia para o servicePedido
	
	@GetMapping //responde a requisição do tipo "get"
	public ResponseEntity<List<Pedido>> localizarTodos(){ //retornar respostas de requisições web
		List<Pedido> lista = servico.localizaTodos();
		return ResponseEntity.ok().body(lista); //retornar a resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> localizarID(@PathVariable Long id){
		Pedido obj = servico.localizarID(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
