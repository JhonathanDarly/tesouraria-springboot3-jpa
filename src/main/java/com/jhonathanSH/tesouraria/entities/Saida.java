package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_saida")
public class Saida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "itemSaida_id")
	private ItemSaida itemSaida;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "relatorio_id")
	private Relatorio relatorio;

	public Saida() {
	}

	public Saida(Long id, Instant momento, Double valor, ItemSaida itemSaida, Relatorio relatorio) {
		super();
		this.id = id;
		this.momento = momento;
		this.valor = valor;
		this.itemSaida = itemSaida;
		this.relatorio = relatorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ItemSaida getItemSaida() {
		return itemSaida;
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemSaida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saida other = (Saida) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemSaida, other.itemSaida);
	}
	
	
}
