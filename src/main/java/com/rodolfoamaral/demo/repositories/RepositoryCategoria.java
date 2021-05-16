package com.rodolfoamaral.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoamaral.demo.entities.Categoria;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long> {

}
