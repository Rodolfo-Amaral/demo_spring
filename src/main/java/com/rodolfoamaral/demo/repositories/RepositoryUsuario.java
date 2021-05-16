package com.rodolfoamaral.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoamaral.demo.entities.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

}
