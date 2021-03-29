package com.dam.DAMHibernate_1aN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conductor {

	@Id
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private String telefono;
	

	public Conductor(String dni, String nombre, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
