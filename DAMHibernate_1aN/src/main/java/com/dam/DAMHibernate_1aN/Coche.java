package com.dam.DAMHibernate_1aN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coche {

	@Id
	private String matricula;
	
	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(foreignKey = @ForeignKey(name = "fk_conductor"))
	private Conductor conductor;

	public Coche(String matricula, String marca, String modelo, Conductor conductor) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.conductor = conductor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	
}