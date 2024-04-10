package com.jhonathanSH.tesouraria.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhonathanSH.tesouraria.entities.Entrada;
import com.jhonathanSH.tesouraria.entities.ItemSaida;
import com.jhonathanSH.tesouraria.entities.Membro;
import com.jhonathanSH.tesouraria.entities.Relatorio;
import com.jhonathanSH.tesouraria.entities.Saida;
import com.jhonathanSH.tesouraria.entities.TipoEntrada;
import com.jhonathanSH.tesouraria.repositories.EntradaRepository;
import com.jhonathanSH.tesouraria.repositories.ItemSaidaRepository;
import com.jhonathanSH.tesouraria.repositories.MembroRepository;
import com.jhonathanSH.tesouraria.repositories.RelatorioRepository;
import com.jhonathanSH.tesouraria.repositories.SaidaRepository;
import com.jhonathanSH.tesouraria.repositories.TipoEntradaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private MembroRepository membroRepository;

	@Autowired
	private TipoEntradaRepository tipoEntradaRepository;

	@Autowired
	private EntradaRepository entradaRepository;

	@Autowired
	private ItemSaidaRepository itemSaidaRepository;

	@Autowired
	private SaidaRepository saidaRepository;

	@Autowired
	private RelatorioRepository relatorioRepository;

	@Override
	@GetMapping
	public void run(String... args) throws Exception {
		Membro m1 = new Membro(null, "Jhonathan", Instant.parse("2018-06-10T19:53:07Z"),
				Instant.parse("1995-08-05T21:00:00Z"), Instant.parse("2014-09-20T07:20:03Z"));
		Membro m2 = new Membro(null, "Bianca", Instant.parse("2018-05-20T19:53:07Z"),
				Instant.parse("1990-09-22T21:00:00Z"), Instant.parse("2012-08-05T07:20:03Z"));

		TipoEntrada te1 = new TipoEntrada(null, "Dizimo");
		TipoEntrada te2 = new TipoEntrada(null, "Oferta");

		Entrada e1 = new Entrada(null, Instant.parse("2024-04-10T19:20:07Z"), 250.00, te1, m1);
		Entrada e2 = new Entrada(null, Instant.parse("2024-04-20T14:53:07Z"), 100.00, te2, m2);
		Entrada e3 = new Entrada(null, Instant.parse("2024-04-30T12:00:07Z"), 300.00, te2, m1);

		ItemSaida is1 = new ItemSaida(null, "Energia");
		ItemSaida is2 = new ItemSaida(null, "Zeladoria");
		ItemSaida is3 = new ItemSaida(null, "Côngrua");

		Saida s1 = new Saida(null, Instant.parse("2024-04-02T08:20:07Z"), 6000.00, is3);
		Saida s2 = new Saida(null, Instant.parse("2024-04-10T10:30:07Z"), 320.00, is1);
		Saida s3 = new Saida(null, Instant.parse("2024-04-05T17:00:07Z"), 450.00, is2);

		Set<Saida> saidas = new HashSet<>();

		saidas.add(s1);
		saidas.add(s2);
		saidas.add(s3);

		membroRepository.saveAll(Arrays.asList(m1, m2));
		tipoEntradaRepository.saveAll(Arrays.asList(te1, te2));
		entradaRepository.saveAll(Arrays.asList(e1, e2, e3));
		itemSaidaRepository.saveAll(Arrays.asList(is1, is2, is3));
		saidaRepository.saveAll(Arrays.asList(s1,s2,s3));

		Set<Entrada> entradas = new HashSet<>();

		entradas.add(e1);
		entradas.add(e2);
		entradas.add(e3);

		Relatorio rel1 = new Relatorio(null, Instant.parse("2024-04-10T00:00:00Z"),
				Instant.parse("2024-04-20T23:59:59Z"), entradas, saidas);
		
		Relatorio rel2 = new Relatorio(null, Instant.parse("2024-04-02T00:00:00Z"),
				Instant.parse("2024-04-08T23:59:59Z"), entradas, saidas);
		
		Relatorio rel3 = new Relatorio(null, Instant.parse("2024-04-01T00:00:00Z"),
				Instant.parse("2024-04-30T23:59:59Z"), entradas, saidas);

		relatorioRepository.saveAll(Arrays.asList(rel1,rel2));

		System.out.println("===================================================");
		System.out.println("Total das entradas no periodo foi de R$ " + rel1.getTotalGeralEntrada());
		System.out.println("----------------------------------------------------");
		System.out.println("Total saida do periodo: R$ " + rel2.getTotalGeralSaida());
		System.out.println("----------------------------------------------------");
		System.out.println("Saldo final do periodo: R$ " + rel3.getSaldoFinal());
		System.out.println("===================================================");

	}

}
