package com.murilobj.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.murilobj.domain.Pedido;
import com.murilobj.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	/*
	 * @RequestMapping(value="(/id)",method=RequestMethod.GET)
	 * 
	 * @ResponseBody public ResponseEntity<?>find(@PathVariable Integer id) {
	 * 
	 * 
	 * Pedido obj = service.find(id); return ResponseEntity.ok().body(obj);
	 * 
	 * 
	 * }
	 */ @GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Pedido obj = service.find(id);
		if (obj == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Objeto não encontrado! id: " + id + ",Tipo: " + Pedido.class.getName());

		}
		/*
		 * throw new ObjectNotFoundException("Objeto não encontrado! id: " + id +
		 * ",Tipo: " + Pedido.class.getName()); }
		 */

		return ResponseEntity.ok().body(obj);
	 }

	 @RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj) {
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
			
		

	}


