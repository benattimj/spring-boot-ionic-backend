package com.murilobj.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.murilobj.domain.Address;
import com.murilobj.domain.City;
import com.murilobj.domain.Cliente;
import com.murilobj.domain.enums.TipoCliente;
import com.murilobj.dto.ClienteDTO;
import com.murilobj.dto.ClienteNewDTO;
import com.murilobj.repositories.AddressRepository;
import com.murilobj.repositories.CityRepository;
import com.murilobj.repositories.ClienteRepository;
import com.murilobj.services.exception.DataIntegrityException;

	@Service
	public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private AddressRepository AddressRepository;
	@Autowired
	private CityRepository cityRepository;
	
	public Cliente find(Integer id) { 
		 Optional<Cliente> obj = repo.findById(id); 
			 return obj.orElse(null); 
	}

	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		AddressRepository.saveAll(obj.getAddress());
		return obj;
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

	public Cliente fromDTO(ClienteNewDTO objDto) {
		
		Cliente cli = new Cliente(null, objDto.getName(),objDto.getEmail(),objDto.getCpf_or_cnpj(),null, TipoCliente.toEnum(objDto.getTipo()));
			
		Optional<City> cid = cityRepository.findById(objDto.getCidadeId());
		
		Address adr = new Address(null, objDto.getTown(), objDto.getPostcode(), objDto.getNumber(), objDto.getAddressLine(), cli, cid.get());
		
		
		cli.getAddress().add(adr);
		cli.getTelefones().add(objDto.getTelephone());
		if (objDto.getTelephone2()!=null) {
			cli.getTelefones().add(objDto.getTelephone2());
		}
		if (objDto.getTelephone3()!=null) {
			cli.getTelefones().add(objDto.getTelephone3());
		}
		
		return cli;
	}
	
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	}
