package com.rodolfoamaral.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.demo.entities.Produto;
import com.rodolfoamaral.demo.repositories.RepositoryProduto;

@Service
public class ServicesProduto {
	
	@Autowired
	private RepositoryProduto repoProduto;
	
	//RETORNAR TODOS ProdutoS DO BANCO
	public List<Produto> localizaTodos() {
		return repoProduto.findAll();
	}
	
	//BUSCAR PELA ID
	public Produto localizarID(Long id) {
		Optional<Produto> obj = repoProduto.findById(id);
		return obj.get(); //retornar o obj dentro do optional
	}

}
