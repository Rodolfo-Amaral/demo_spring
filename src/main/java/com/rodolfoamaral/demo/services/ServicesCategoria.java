package com.rodolfoamaral.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.demo.entities.Categoria;
import com.rodolfoamaral.demo.repositories.RepositoryCategoria;

@Service
public class ServicesCategoria {
	
	@Autowired
	private RepositoryCategoria repoCategoria;
	
	//RETORNAR TODOS CategoriaS DO BANCO
	public List<Categoria> localizaTodos() {
		return repoCategoria.findAll();
	}
	
	//BUSCAR USER PELA ID
	public Categoria localizarID(Long id) {
		Optional<Categoria> obj = repoCategoria.findById(id);
		return obj.get(); //retornar o obj dentro do optional
	}

}
