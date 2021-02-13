package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jefe {

	@Id
	private int codigo_jefe;
	
	@Column
	private String nombre_jefe;
	
	@Column
	private String apellido_jefe;
	
	@Column
	private double nomina_jefe;

	
	public Jefe() {}
	
	
    public void setCodigo_jefe(int codigo_jefe) {
		this.codigo_jefe = codigo_jefe;
	}

	public void setNombre_jefe(String nombre_jefe) {
		this.nombre_jefe = nombre_jefe;
	}

	public void setApellido_jefe(String apellido_jefe) {
		this.apellido_jefe = apellido_jefe;
	}

	public void setNomina_jefe(double nomina_jefe) {
		this.nomina_jefe = nomina_jefe;
	}

	public int getCodigo_jefe() {
		return codigo_jefe;
	}

	public String getNombre_jefe() {
		return nombre_jefe;
	}

	public String getApellido_jefe() {
		return apellido_jefe;
	}


	public double getNomina_jefe() {
		return nomina_jefe;
	}

	

	
	
}
