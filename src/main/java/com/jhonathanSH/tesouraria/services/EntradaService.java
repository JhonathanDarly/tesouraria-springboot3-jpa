package com.jhonathanSH.tesouraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathanSH.tesouraria.entities.Entrada;
import com.jhonathanSH.tesouraria.repositories.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository repository;
	
	public List<Entrada> findAll(){
		return repository.findAll();
	}
	public Entrada findById(Long id) {
		Optional<Entrada> obj = repository.findById(id);
		return obj.get();
	}
}
