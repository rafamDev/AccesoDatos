package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Asir extends Ciclo{

	@Column
	private String so;
	
	public Asir(String codigo,Alumno alumno,String so) {
		super(codigo,alumno);
		this.so = so;
	}

	public String getSo() {
		return so;
	}

}