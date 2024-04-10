package com.jhonathanSH.tesouraria.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonathanSH.tesouraria.entities.Relatorio;
import com.jhonathanSH.tesouraria.services.RelatorioService;


@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioResource {
	
	@Autowired
	private RelatorioService service;

	//End Point para buscar todos as entradas
	@GetMapping
	public ResponseEntity<List<Relatorio>> findAll() {
		List<Relatorio> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//End Point para buscar entrada por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Relatorio> findById(@PathVariable Long id){
		Relatorio obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
