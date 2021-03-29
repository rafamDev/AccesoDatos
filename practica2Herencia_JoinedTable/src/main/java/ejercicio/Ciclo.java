package ejercicio;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
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