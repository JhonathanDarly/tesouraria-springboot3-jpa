package com.jhonathanSH.tesouraria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonathanSH.tesouraria.entities.TipoEntrada;
import com.jhonathanSH.tesouraria.services.TipoEntradaService;


@RestController
@RequestMapping(value = "/tipo-entradas")
public class TipoEntradaResource {
	
	@Autowired
	private TipoEntradaService service;

	//End Point para buscar todos as entradas
	@GetMapping
	public ResponseEntity<List<TipoEntrada>> findAll() {
		List<TipoEntrada> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//End Point para buscar entrada por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoEntrada> findById(@PathVariable Long id){
		TipoEntrada obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
