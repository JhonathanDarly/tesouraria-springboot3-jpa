package com.jhonathanSH.tesouraria.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_membro")
=======
>>>>>>> b5f1873fe57eff3e98528e60b427e5a57c44fdd4
public class Membro implements Serializable{

	private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date registroMembresia;
=======
	private Long id;
	private String name;
	private Date registrMembresia;
>>>>>>> b5f1873fe57eff3e98528e60b427e5a57c44fdd4
	private Date aniversario;
	private Date bastismo;
	
	public Membro() {
	}

	public Membro(Long id, String name, Date registrMembresia, Date aniversario, Date bastismo) {
		super();
		this.id = id;
		this.name = name;
<<<<<<< HEAD
		this.registroMembresia = registrMembresia;
=======
		this.registrMembresia = registrMembresia;
>>>>>>> b5f1873fe57eff3e98528e60b427e5a57c44fdd4
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
<<<<<<< HEAD
		return registroMembresia;
	}

	public void setRegistrMembresia(Date registrMembresia) {
		this.registroMembresia = registrMembresia;
=======
		return registrMembresia;
	}

	public void setRegistrMembresia(Date registrMembresia) {
		this.registrMembresia = registrMembresia;
>>>>>>> b5f1873fe57eff3e98528e60b427e5a57c44fdd4
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
