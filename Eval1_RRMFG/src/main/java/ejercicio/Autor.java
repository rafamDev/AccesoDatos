package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {

	@Id
	private int codigo;
	
	@Column
	private String nombre;
	
	@Column
	private String pais;

	public Autor(int codigo, String nombre, String pais) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pais = pais;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPais() {
		return pais;
	}

	
}
