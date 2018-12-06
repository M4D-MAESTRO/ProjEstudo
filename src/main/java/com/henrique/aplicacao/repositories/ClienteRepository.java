package com.henrique.aplicacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henrique.aplicacao.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{}
