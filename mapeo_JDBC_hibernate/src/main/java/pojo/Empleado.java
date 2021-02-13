package pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empleado {

	@Id
	private int codigo_empleado;
	
	@Column
	private String nombre_empleado;
	
	@Column
	private String apellido_empleado;
	
	@Column
	private double nomina_empleado;

	
	public Empleado() {}
	
	
	public void setCodigo_empleado(int codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
	}

	public void setApellido_empleado(String apellido_empleado) {
		this.apellido_empleado = apellido_empleado;
	}

	public void setNomina_empleado(double nomina_empleado) {
		this.nomina_empleado = nomina_empleado;
	}

	public int getCodigo_empleado() {
		return codigo_empleado;
	}

	public String getNombre_empleado() {
		return nombre_empleado;
	}


    public String getApellido_empleado() {
		return apellido_empleado;
	}

	public double getNomina_empleado() {
		return nomina_empleado;
	}


	


}
