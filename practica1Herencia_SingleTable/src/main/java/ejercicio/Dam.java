package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dam extends Ciclo{

	@Column
	private String tipo;
	
	public Dam(String codigo,Alumno alumno,String tipo) {
		super(codigo,alumno);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
