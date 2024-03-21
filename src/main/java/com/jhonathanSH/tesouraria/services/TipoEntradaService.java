package com.jhonathanSH.tesouraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathanSH.tesouraria.entities.TipoEntrada;
import com.jhonathanSH.tesouraria.repositories.TipoEntradaRepository;

@Service
public class TipoEntradaService {

	@Autowired
	private TipoEntradaRepository repository;
	
	public List<TipoEntrada> findAll(){
		return repository.findAll();
	}
	public TipoEntrada findById(Long id) {
		Optional<TipoEntrada> obj = repository.findById(id);
		return obj.get();
	}
}
