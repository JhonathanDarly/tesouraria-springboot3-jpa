package com.jhonathanSH.tesouraria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonathanSH.tesouraria.entities.ItemSaida;
import com.jhonathanSH.tesouraria.services.ItemSaidaService;


@RestController
@RequestMapping(value = "/itens-saidas")
public class ItemSaidaResource {
	
	@Autowired
	private ItemSaidaService service;

	//End Point para buscar todos os membros
	@GetMapping
	public ResponseEntity<List<ItemSaida>> findAll() {
		List<ItemSaida> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//End Point para buscar membro por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemSaida> findById(@PathVariable Long id){
		ItemSaida obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
