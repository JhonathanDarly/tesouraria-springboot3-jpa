package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_relatorio")
public class Relatorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Instant dataInicial;
	
	private Instant dataFinal;

	
	@OneToMany(mappedBy = "relatorio")
	private Set<Entrada> entradas = new HashSet<>();
	
	@OneToMany(mappedBy = "relatorio")
	private Set<Saida> saidas = new HashSet<>();
	
	public Relatorio() {
	}
		
	public Relatorio(Long id, Instant dataInicial, Instant dataFinal, Set<Entrada> entradas, Set<Saida> saidas) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.entradas = entradas;
		this.saidas = saidas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Instant dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Instant getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Instant dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Set<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}

	public Set<Saida> getSaidas() {
		return saidas;
	}

	public void setSaidas(Set<Saida> saidas) {
		this.saidas = saidas;
	}

	public double getTotalGeralEntrada() {
		double sum = 0.0;
		for (Entrada x : entradas) {
			if (x.getMomento().compareTo(dataInicial) >= 0 && x.getMomento().compareTo(dataFinal) <= 0) {
				sum += x.getValor();
			} 
		}
		return sum;
	}	
	
	public double getTotalGeralSaida() {	
		double sum = 0.0;
		for (Saida x : saidas) {
			if (x.getMomento().compareTo(dataInicial) >= 0 && x.getMomento().compareTo(dataFinal) <= 0) {
			sum += x.getValor();
			}
		}		
		return sum;
	}
	
	public double getSaldoFinal() {
		
		double sum = getTotalGeralEntrada() - getTotalGeralSaida();
		return sum;
	} 

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relatorio other = (Relatorio) obj;
		return Objects.equals(id, other.id);
	}	
	
}
