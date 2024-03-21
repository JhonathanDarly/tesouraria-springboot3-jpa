package com.jhonathanSH.tesouraria.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhonathanSH.tesouraria.entities.Entrada;
import com.jhonathanSH.tesouraria.entities.ItemSaida;
import com.jhonathanSH.tesouraria.entities.Membro;
import com.jhonathanSH.tesouraria.entities.Saida;
import com.jhonathanSH.tesouraria.entities.TipoEntrada;
import com.jhonathanSH.tesouraria.repositories.EntradaRepository;
import com.jhonathanSH.tesouraria.repositories.ItemSaidaRepository;
import com.jhonathanSH.tesouraria.repositories.MembroRepository;
import com.jhonathanSH.tesouraria.repositories.SaidaRepository;
import com.jhonathanSH.tesouraria.repositories.TipoEntradaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private TipoEntradaRepository tipoEntradaRepository;
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private ItemSaidaRepository itemSaidaRepository ;
	
	@Autowired
	private SaidaRepository saidaRepository;
	
	@Override
	@GetMapping
	public void run(String... args) throws Exception {
		Membro m1 = new Membro(null, "Jhonathan", Instant.parse("2018-06-10T19:53:07Z"),Instant.parse("1995-08-05T21:00:00Z"),Instant.parse("2014-09-20T07:20:03Z"));
		Membro m2 = new Membro(null, "Bianca",Instant.parse("2018-05-20T19:53:07Z"),Instant.parse("1990-09-22T21:00:00Z"),Instant.parse("2012-08-05T07:20:03Z"));
		
		TipoEntrada te1 = new TipoEntrada(null, "Dizimo");
		TipoEntrada te2 = new TipoEntrada(null, "Ofertar");
		
		
		Entrada e1 = new Entrada(null, Instant.now(), 100.0, te1,m1);
		Entrada e2 = new Entrada(null, Instant.now(), 100.0, te2, m2);
		Entrada e3 = new Entrada(null, Instant.now(), 100.0, te2, m1);
		
		
		ItemSaida is1 = new ItemSaida(null, "Energia");
		ItemSaida is2 = new ItemSaida(null, "Zeladoria");
		ItemSaida is3 = new ItemSaida(null, "Côngrua");
		
		Saida s1 = new Saida(null, Instant.now(), 320.0, is1);	
		
		
		membroRepository.saveAll(Arrays.asList(m1, m2));
		tipoEntradaRepository.saveAll(Arrays.asList(te1, te2));
		entradaRepository.saveAll(Arrays.asList(e1, e2, e3));		
		itemSaidaRepository.saveAll(Arrays.asList(is1,is2, is3));
		saidaRepository.saveAll(Arrays.asList(s1));
	
	}
	
	
}
