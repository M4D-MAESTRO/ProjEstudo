package com.henrique.aplicacao.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.henrique.aplicacao.domain.Categoria;
import com.henrique.aplicacao.repositories.CategoriaRepository;
import com.henrique.aplicacao.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		repo.save(obj);	
		return obj;
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		repo.save(obj);	
		return obj;
	}

}
