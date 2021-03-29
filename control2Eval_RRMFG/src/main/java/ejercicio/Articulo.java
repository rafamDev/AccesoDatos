package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Articulo {

	@Id
	private int codigo;
	
	@Column
	private String nombre;
	
	@Column
	private double precio;

	public Articulo(int codigo, String nombre, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}
	
	
}
