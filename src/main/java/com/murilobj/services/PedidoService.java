package com.murilobj.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilobj.domain.Pedido;
import com.murilobj.repositories.PedidoRepository;
import com.murilobj.services.exception.ObjectNotFoundException;

	@Service
	public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) { 
		 Optional<Pedido> obj = repo.findById(id); 
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: " + id 
					+ ",Tipo: " + Pedido.class.getName());
						
		}
		 return obj.orElse(null); 
	}

	public Pedido buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
