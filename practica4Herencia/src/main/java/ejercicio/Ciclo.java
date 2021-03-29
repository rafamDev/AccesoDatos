package ejercicio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Ciclo {
  
	@Id
	private String codigo;
     
	@ManyToOne
    private Alumno alumno;

	public Ciclo(String codigo,Alumno alumno) {
	   this.codigo = codigo;
	   this.alumno = alumno;
	}

	public String getCodigo() {
		return codigo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

}