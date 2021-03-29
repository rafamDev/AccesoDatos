package ejercicio;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Preventa extends Articulo {

	@CreationTimestamp
	private Timestamp fecha_salida;
	
	public Preventa(int codigo, String nombre, double precio) {
		super(codigo, nombre, precio);
	}

	public Timestamp getFecha_salida() {
		return fecha_salida;
	}

	
}
