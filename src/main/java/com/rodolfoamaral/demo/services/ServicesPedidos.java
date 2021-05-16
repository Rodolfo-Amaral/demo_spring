package com.rodolfoamaral.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.demo.entities.Pedido;
import com.rodolfoamaral.demo.repositories.RepositoryPedido;

@Service
public class ServicesPedidos {
	
	@Autowired
	private RepositoryPedido repoPedido;
	
	//RETORNAR TODOS PEDIDOS DO BANCO
	public List<Pedido> localizaTodos() {
		return repoPedido.findAll();
	}
	
	public Pedido localizarID(Long id) {
		Optional<Pedido> obj = repoPedido.findById(id);
		return obj.get(); //retornar o obj dentro do optional
	}

}
