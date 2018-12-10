package com.henrique.aplicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henrique.aplicacao.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{}
