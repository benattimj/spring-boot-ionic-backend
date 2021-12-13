package com.murilobj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.murilobj.domain.Cliente;
import com.murilobj.dto.ClienteDTO;
import com.murilobj.repositories.ClienteRepository;
import com.murilobj.services.exception.DataIntegrityException;

	@Service
	public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) { 
		 Optional<Cliente> obj = repo.findById(id); 
			 return obj.orElse(null); 
	}

	public Cliente update (Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete (Integer id) {
		find(id);
			try {
		repo.deleteById(id);
	}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Not Possible exclude because there are related entities");
		}
	}	
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy,String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}	
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getName(),objDto.getEmail(),null,null, null);
		}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	}
