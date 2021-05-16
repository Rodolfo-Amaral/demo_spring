package com.rodolfoamaral.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoamaral.demo.entities.Pedido;

public interface RepositoryPedido extends JpaRepository<Pedido, Long> {

}
