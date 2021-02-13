package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empleado {

	@Id
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String cargo;
	@Column
	private int nomina;
	@Column
	private int departamento;
	
	
	public Empleado(int codigo, String nombre, String apellido, String cargo, int nomina, int departamento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.nomina = nomina;
		this.departamento = departamento;
	}
	

	
	
}
