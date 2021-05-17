package com.rodolfoamaral.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodolfoamaral.demo.entities.ItemPedido;

public interface RepositoryItemPedido extends JpaRepository<ItemPedido, Long> {

}
