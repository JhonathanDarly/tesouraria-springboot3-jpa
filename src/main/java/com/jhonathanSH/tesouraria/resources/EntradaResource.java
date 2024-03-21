package com.jhonathanSH.tesouraria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonathanSH.tesouraria.entities.Entrada;
import com.jhonathanSH.tesouraria.services.EntradaService;


@RestController
@RequestMapping(value = "/entradas")
public class EntradaResource {
	
	@Autowired
	private EntradaService service;

	//End Point para buscar todos as entradas
	@GetMapping
	public ResponseEntity<List<Entrada>> findAll() {
		List<Entrada> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//End Point para buscar entrada por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrada> findById(@PathVariable Long id){
		Entrada obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
