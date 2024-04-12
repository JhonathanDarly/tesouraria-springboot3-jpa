package com.jhonathanSH.tesouraria.config;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

	public static Relatorio relatorioGeral;
	
	
	public Relatorio getRelatorioGeral() {
		return relatorioGeral;
	}

	@Override
	@GetMapping
	public void run(String... args) throws Exception {
	
	
		Membro membro1 = new Membro(null, "Jhonathan", Instant.parse("2018-06-10T19:53:07Z"),
				Instant.parse("1995-08-05T21:00:00Z"), Instant.parse("2014-09-20T07:20:03Z"));
		Membro membro2 = new Membro(null, "Bianca", Instant.parse("2018-05-20T19:53:07Z"),
				Instant.parse("1990-09-22T21:00:00Z"), Instant.parse("2012-08-05T07:20:03Z"));

		membroRepository.saveAll(Arrays.asList(membro1, membro2));

		TipoEntrada tipoEntrada1 = new TipoEntrada(null, "Dizimo");
		TipoEntrada tipoEntrada2 = new TipoEntrada(null, "Oferta");

		tipoEntradaRepository.saveAll(Arrays.asList(tipoEntrada1, tipoEntrada2));

		Entrada e1 = new Entrada(null, Instant.parse("2024-04-10T19:20:07Z"), 250.00, tipoEntrada1, membro1, null);
		Entrada e2 = new Entrada(null, Instant.parse("2024-04-05T14:53:07Z"), 100.00, tipoEntrada2, membro2, null);
		Entrada e3 = new Entrada(null, Instant.parse("2024-04-02T12:00:07Z"), 300.00, tipoEntrada2, membro1, null);

		entradaRepository.saveAll(Arrays.asList(e1, e2, e3));

		Set<Entrada> entradas = new HashSet<>();

		entradas.add(e1);
		entradas.add(e2);
		entradas.add(e3);

		entradaRepository.saveAll(Arrays.asList(e1, e2, e3));

		ItemSaida is1 = new ItemSaida(null, "Energia");
		ItemSaida is2 = new ItemSaida(null, "Zeladoria");
		ItemSaida is3 = new ItemSaida(null, "Côngrua");

		itemSaidaRepository.saveAll(Arrays.asList(is1, is2, is3));

		Saida s1 = new Saida(null, Instant.parse("2024-04-02T08:20:07Z"), 6000.00, is3, null);
		Saida s2 = new Saida(null, Instant.parse("2024-04-10T10:30:07Z"), 320.00, is1, null);
		Saida s3 = new Saida(null, Instant.parse("2024-04-05T17:00:07Z"), 450.00, is2, null);

		Set<Saida> saidas = new HashSet<>();

		saidas.add(s1);
		saidas.add(s2);
		saidas.add(s3);

		saidaRepository.saveAll(Arrays.asList(s1, s2, s3));

		
		Instant dataInicial = Instant.parse("2024-04-01T01:00:00Z");
		Instant dataFinal = Instant.parse("2024-04-30T23:59:59Z");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());		
	
		
		String dataInicialF = formatter.format(dataInicial);
		String dataFinalF = formatter.format(dataFinal);
		

		Relatorio rel1 = new Relatorio(null, dataInicial, dataFinal, entradas, saidas);

		Relatorio rel2 = new Relatorio(null, dataInicial, dataFinal, entradas, saidas, tipoEntrada2);

		Relatorio rel3 = new Relatorio(null, dataInicial, dataFinal, entradas, saidas, tipoEntrada1);

		Relatorio rel4 = new Relatorio(null, dataInicial, dataFinal, entradas, saidas, is1);

		Relatorio rel5 = new Relatorio(null, dataInicial, dataFinal, entradas, saidas, is2);

		Relatorio rel6 = new Relatorio(null, dataInicial, dataFinal, entradas, saidas, is3);

		Relatorio relatorio = new Relatorio();
		
		relatorioGeral = new Relatorio(null, dataInicial, dataFinal, entradas, saidas);
		
		relatorioRepository.saveAll(Arrays.asList(rel1, rel2, rel3, rel4, rel5, rel6, relatorio, relatorioGeral));

		e1.setRelatorio(rel1);
		e2.setRelatorio(rel1);
		e3.setRelatorio(rel1);

		s1.setRelatorio(rel1);
		s2.setRelatorio(rel1);
		s3.setRelatorio(rel1);

		entradaRepository.saveAll(Arrays.asList(e1, e2, e3));
		saidaRepository.saveAll(Arrays.asList(s1, s2, s3));	
	

		System.out.println("===================================================");
		System.out.println("Total das entradas de " + dataInicialF + " à " + dataFinalF + " foi de R$ " + rel1.getTotalGeralEntrada());
		System.out.println("----------------------------------------------------");
		System.out.println("Total por tipo Oferta: R$ " + rel2.getTotalTipoEntrada());
		System.out.println("----------------------------------------------------");
		System.out.println("Total por tipo Dizimo: R$ " + rel3.getTotalTipoEntrada());
		System.out.println("===================================================");
		System.out.println("Total saida no mesmo periodo: R$ " + rel1.getTotalGeralSaida());
		System.out.println("----------------------------------------------------");
		System.out.println("Total por saida " + is1.getNome() + ": R$ " + rel4.getTotalItemSaida());
		System.out.println("----------------------------------------------------");
		System.out.println("total por saida " + is2.getNome() + ": R$ " + rel5.getTotalItemSaida());
		System.out.println("----------------------------------------------------");
		System.out.println("total por saida " + is3.getNome() + " R$ " + rel6.getTotalItemSaida());
		System.out.println("===================================================");
		System.out.println("Saldo final do periodo: ***** R$ " + rel1.getSaldoFinal() + " *****");
		System.out.println("===================================================");

		


	}

}
