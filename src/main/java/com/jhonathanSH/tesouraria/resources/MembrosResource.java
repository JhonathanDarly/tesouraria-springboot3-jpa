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
<<<<<<< HEAD
		Membro m = new Membro(null, "Jhonathan", null, null, null);
=======
		Membro m = new Membro(1L, "Jhonathan", null, null, null);
>>>>>>> b5f1873fe57eff3e98528e60b427e5a57c44fdd4
		return ResponseEntity.ok().body(m);
	}

}
