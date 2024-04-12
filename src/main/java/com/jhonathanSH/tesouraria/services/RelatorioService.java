package com.jhonathanSH.tesouraria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhonathanSH.tesouraria.config.TestConfig;
import com.jhonathanSH.tesouraria.entities.Relatorio;
import com.jhonathanSH.tesouraria.repositories.RelatorioRepository;

@Service
public class RelatorioService {

	@Autowired
	private RelatorioRepository repository;

	public List<Relatorio> findAll() {
		return repository.findAll();
	}
	

	public Relatorio findById(Long id) {
		Optional<Relatorio> obj = repository.findById(id);
		return obj.get();
	}

	 // Método para gerar o relatório
    public String gerarRelatorio() {
    	
        StringBuilder printRelatorio = new StringBuilder();
        
        Relatorio relatorio = TestConfig.relatorioGeral;
        
        printRelatorio.append("Total das entradas de ")
        .append(relatorio.getDataInicial())
        .append(" à ")
        .append(relatorio.getDataFinal())
        .append(" foi R$ ")
        .append(relatorio.getTotalGeralEntrada())
        .append("\nTotal por tipo oferta: R$ ");       
        return printRelatorio.toString();
    }
}

/*
 * System.out.println("===================================================");
 * System.out.println("Total das entradas de " + dataInicialF + " à " +
 * dataFinalF + " foi de R$ " + rel1.getTotalGeralEntrada());
 * System.out.println("----------------------------------------------------");
 * System.out.println("Total por tipo Oferta: R$ " +
 * rel2.getTotalTipoEntrada());
 * System.out.println("----------------------------------------------------");
 * System.out.println("Total por tipo Dizimo: R$ " +
 * rel3.getTotalTipoEntrada());
 * System.out.println("===================================================");
 * System.out.println("Total saida no mesmo periodo: R$ " +
 * rel1.getTotalGeralSaida());
 * System.out.println("----------------------------------------------------");
 * System.out.println("Total por saida " + is1.getNome() + ": R$ " +
 * rel4.getTotalItemSaida());
 * System.out.println("----------------------------------------------------");
 * System.out.println("total por saida " + is2.getNome() + ": R$ " +
 * rel5.getTotalItemSaida());
 * System.out.println("----------------------------------------------------");
 * System.out.println("total por saida " + is3.getNome() + " R$ " +
 * rel6.getTotalItemSaida());
 * System.out.println("===================================================");
 * System.out.println("Saldo final do periodo: ***** R$ " + rel1.getSaldoFinal()
 * + " *****");
 * System.out.println("===================================================");
 */