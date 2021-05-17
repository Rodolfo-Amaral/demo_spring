package com.rodolfoamaral.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodolfoamaral.demo.entities.Usuario;
import com.rodolfoamaral.demo.repositories.RepositoryUsuario;
import com.rodolfoamaral.demo.services.exceptions.ResourceNotFoundExcecao;

@Service
public class ServicesUsuario {
	
	@Autowired
	private RepositoryUsuario repoUsuario;
	
	//RETORNAR TODOS USUARIOS DO BANCO
	public List<Usuario> localizaTodos() {
		return repoUsuario.findAll();
	}
	
	//BUSCAR USER PELA ID
	public Usuario localizarID(Long id) {
		Optional<Usuario> obj = repoUsuario.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundExcecao(id));
	}
	
	public Usuario inserirUsuario(Usuario obj) {
		return repoUsuario.save(obj);
	}
	
	public void deletarUsuario(Long id) {
		repoUsuario.deleteById(id);
	}

	public Usuario atualizarUsuario(Long id, Usuario obj) {
		Usuario user = repoUsuario.getOne(id);
		atualizarDados(user, obj);
		return repoUsuario.save(user);		
	}

	private void atualizarDados(Usuario user, Usuario obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setFone(obj.getFone());		
	}
}
