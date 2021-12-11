package com.murilobj.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.murilobj.domain.Categoria;
import com.murilobj.repositories.CategoriaRepository;
import com.murilobj.services.exception.DataIntegrityException;

	@Service
	public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) { 
		 Optional<Categoria> obj = repo.findById(id); 
		
		 return obj.orElse(null); 
	}

	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	

	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) {
		find(id);
		try {
		repo.deleteById(id);
	}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not Possible exclude a Categoria with produtos");
		}
}	
}

	