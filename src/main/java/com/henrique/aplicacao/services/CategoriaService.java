package com.henrique.aplicacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.henrique.aplicacao.domain.Categoria;
import com.henrique.aplicacao.dto.CategoriaDTO;
import com.henrique.aplicacao.repositories.CategoriaRepository;
import com.henrique.aplicacao.services.exceptions.DataIntegrityException;
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
	
	public void delete(Integer id) {
		find(id);
		
		try {
			repo.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos cadastrados");
		};
		
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}

}
