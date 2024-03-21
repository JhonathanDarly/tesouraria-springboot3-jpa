package com.jhonathanSH.tesouraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathanSH.tesouraria.entities.ItemSaida;
import com.jhonathanSH.tesouraria.repositories.ItemSaidaRepository;

@Service
public class ItemSaidaService {

	@Autowired
	private ItemSaidaRepository repository;
	
	public List<ItemSaida> findAll(){
		return repository.findAll();
	}
	public ItemSaida findById(Long id) {
		Optional<ItemSaida> obj = repository.findById(id);
		return obj.get();
	}
}
