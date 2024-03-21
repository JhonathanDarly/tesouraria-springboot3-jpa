package com.jhonathanSH.tesouraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathanSH.tesouraria.entities.Membro;
import com.jhonathanSH.tesouraria.repositories.MembroRepository;

@Service
public class MembroService {

	@Autowired
	private MembroRepository repository;
	
	public List<Membro> findAll(){
		return repository.findAll();
	}
	public Membro findById(Long id) {
		Optional<Membro> obj = repository.findById(id);
		return obj.get();
	}
}
