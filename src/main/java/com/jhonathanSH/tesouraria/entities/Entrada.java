package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_entrada")
public class Entrada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private Double valor;
	

	private TipoEntrada tipoEntrada;

	@ManyToOne
	@JoinColumn(name = "membro_id")
	private Membro membro;

	@ManyToOne
	@JoinColumn(name = "relatorio_id")
	Relatorio relatorio;
	
	public Entrada() {
	}

	public Entrada(Long id, Instant momento, Double valor, TipoEntrada tipoEntrada, Membro membro) {
		super();
		this.id = id;
		this.momento = momento;
		this.valor = valor;
		this.tipoEntrada = tipoEntrada;
		this.membro = membro;
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

	public TipoEntrada getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(TipoEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}
	
	@Override
	public int hashCode(){
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
		Entrada other = (Entrada) obj;
		return Objects.equals(id, other.id);
	}

}
