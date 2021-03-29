package practica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Mercancia {

	@Id
	private String codigo;
	
	@Column
	private String nombre;
	
	@Column
	private String origen;
	
	@Column
	private String destino;

	public Mercancia(String codigo, String nombre, String origen, String destino) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.origen = origen;
		this.destino = destino;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}
	
	
}
