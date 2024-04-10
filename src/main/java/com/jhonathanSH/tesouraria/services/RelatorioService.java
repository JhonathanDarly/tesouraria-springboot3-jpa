package com.jhonathanSH.tesouraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathanSH.tesouraria.entities.Relatorio;
import com.jhonathanSH.tesouraria.repositories.RelatorioRepository;

@Service
public class RelatorioService {

	@Autowired
	private RelatorioRepository repository;
	
	public List<Relatorio> findAll(){
		return repository.findAll();
	}
	public Relatorio findById(Long id) {
		Optional<Relatorio> obj = repository.findById(id);
		return obj.get();
	}
}
