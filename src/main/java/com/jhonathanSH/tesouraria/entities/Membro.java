package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_membro")
public class Membro implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Instant registroMembresia;
	private Instant aniversario;
	private Instant batismo;
	
	
	
	public Membro() {
	}

	public Membro(Long id, String nome, Instant registroMembresia, Instant aniversario, Instant batismo) {
		super();
		this.id = id;
		this.nome = nome;
		this.registroMembresia = registroMembresia;
		this.aniversario = aniversario;
		this.batismo = batismo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public Instant getRegistroMembresia() {
		return registroMembresia;
	}

	public void setRegistroMembresia(Instant registroMembresia) {
		this.registroMembresia = registroMembresia;
	}

	public Instant getAniversario() {
	return aniversario;
	}

	public void setAniversario(Instant aniversario) {
		this.aniversario = aniversario;
	}

	public Instant getBatismo() {
		return batismo;
	}

	public void setBatismo(Instant batismo) {
		this.batismo = batismo;
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
		Membro other = (Membro) obj;
		return Objects.equals(id, other.id);
	}
	
}
