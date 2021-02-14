package ejercicio2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamento {
	@Id
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String localidad;
	
	public Departamento(int codigo, String nombre, String localidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

}
