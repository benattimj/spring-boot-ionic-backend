package com.murilobj.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.murilobj.domain.Categoria;
import com.murilobj.dto.CategoriaDTO;
import com.murilobj.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired	
	private CategoriaService service;
	/*
	@RequestMapping(value="(/id)",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?>find(@PathVariable Integer id) {
		
		
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	

	}
*/	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id ) {
			Categoria obj = service.find(id);
				if (obj == null) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Objeto não encontrado! id: " + id + ",Tipo: " + Categoria.class.getName());
	}
	
			return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method =RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@RequestMapping(value="/{id}", method =RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj,@PathVariable Integer id ){
		obj.setId(id);
		obj =service.update(obj);
		return ResponseEntity.noContent().build();
		}
	@RequestMapping(value="/{id}",method =RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		}
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
			List<Categoria> list = service.findAll();
			List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
				
	}

	@RequestMapping(value= "/page", method =RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page",defaultValue = "0")Integer page,
			@RequestParam(value="linesPerPage",defaultValue = "24")Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue = "nome")String orderBy,
			@RequestParam(value="direction",defaultValue = "ASC")String direction) {
			Page<Categoria> list = service.findPage(page, linesPerPage, orderBy, direction);
			Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
			return ResponseEntity.ok().body(listDto);
				
	}
	
	
}

