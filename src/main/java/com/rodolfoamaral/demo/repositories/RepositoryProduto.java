package com.rodolfoamaral.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoamaral.demo.entities.Produto;

public interface RepositoryProduto extends JpaRepository<Produto, Long> {

}
