package com.jhonathanSH.tesouraria.config;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhonathanSH.tesouraria.entities.Membro;
import com.jhonathanSH.tesouraria.repositories.MembroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private MembroRepository membroRepository;

	@Override
	@GetMapping
	public void run(String... args) throws Exception {
		Membro m1 = new Membro(null, "Jhonathan", null, null, null);
		Membro m2 = new Membro(null, "Bianca", null, null, null);
		
		membroRepository.saveAll(Arrays.asList(m1, m2));
		
	}
	
	
}
