package com.murilobj.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilobj.domain.Cliente;
import com.murilobj.repositories.ClienteRepository;
import com.murilobj.services.exception.ObjectNotFoundException;

	@Service
	public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) { 
		 Optional<Cliente> obj = repo.findById(id); 
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id 
					+ ",Tipo: " + Cliente.class.getName());
						
		}
		 return obj.orElse(null); 
	}

	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
