package ejercicio;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


// Clase Padre -> (Ciclo)
// con campo DTYPE: subclases -> (Dam) (Asir).

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Ciclo {
  
	@Id
	private String codigo;
     
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey)
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
