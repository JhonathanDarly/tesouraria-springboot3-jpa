package com.jhonathanSH.tesouraria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonathanSH.tesouraria.entities.Membro;
import com.jhonathanSH.tesouraria.services.MembroService;


@RestController
@RequestMapping(value = "/membros")
public class MembroResource {
	
	@Autowired
	private MembroService service;

	//End Point para buscar todos os membros
	@GetMapping
	public ResponseEntity<List<Membro>> findAll() {
		List<Membro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//End Point para buscar membro por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Membro> findById(@PathVariable Long id){
		Membro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
