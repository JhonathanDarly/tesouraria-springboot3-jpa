package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Membro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Date registrMembresia;
	private Date aniversario;
	private Date bastismo;
	
	public Membro() {
	}

	public Membro(Long id, String name, Date registrMembresia, Date aniversario, Date bastismo) {
		super();
		this.id = id;
		this.name = name;
		this.registrMembresia = registrMembresia;
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
		return registrMembresia;
	}

	public void setRegistrMembresia(Date registrMembresia) {
		this.registrMembresia = registrMembresia;
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
