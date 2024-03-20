package com.jhonathanSH.tesouraria.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonathanSH.tesouraria.entities.Membro;

@RestController
@RequestMapping(value = "/membros")
public class MembrosResource {
	
	@GetMapping
	public ResponseEntity<Membro> findAll(){
		Membro m = new Membro(null, "Jhonathan", null, null, null);
		return ResponseEntity.ok().body(m);
	}

}
