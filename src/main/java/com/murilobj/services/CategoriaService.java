package com.murilobj.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilobj.domain.Categoria;
import com.murilobj.repositories.CategoriaRepository;
import com.murilobj.services.exception.ObjectNotFoundException;

	@Service
	public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) { 
		 Optional<Categoria> obj = repo.findById(id); 
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id 
					+ ",Tipo: " + Categoria.class.getName());
						
		}
		 return obj.orElse(null); 
	}

	public Categoria buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
