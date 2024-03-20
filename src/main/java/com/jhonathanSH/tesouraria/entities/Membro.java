package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.sql.Date;
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
	private String name;
	private Date registroMembresia;
	private Date aniversario;
	private Date bastismo;
	
	public Membro() {
	}

	public Membro(Long id, String name, Date registrMembresia, Date aniversario, Date bastismo) {
		super();
		this.id = id;
		this.name = name;
		this.registroMembresia = registrMembresia;
		this.aniversario = aniversario;
		this.bastismo = bastismo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrMembresia() {
		return registroMembresia;
	}

	public void setRegistrMembresia(Date registrMembresia) {
		this.registroMembresia = registrMembresia;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public Date getBastismo() {
		return bastismo;
	}

	public void setBastismo(Date bastismo) {
		this.bastismo = bastismo;
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