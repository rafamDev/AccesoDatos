package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Videojuego {

	@Id
	private int codigo;
	
	@Column
	private String nombre;
	
	@Column
	private int anho;
	
	@Column
	private int idDesarrollo;
	
	public Videojuego(int codigo, String nombre, int anho, int idDesarrrollo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.anho = anho;
		this.idDesarrollo = idDesarrrollo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAnho() {
		return anho;
	}

	public int getIdDesarrollo() {
		return idDesarrollo;
	}

}
