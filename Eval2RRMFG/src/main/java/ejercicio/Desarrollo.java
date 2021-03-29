package ejercicio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Desarrollo {

	@Id
	private int codigo;
	
	@Column
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="idDesarrollo",foreignKey = @ForeignKey(name = "fk_desarrollador"))
	private List<Videojuego> lista_videojuego;
	
	public Desarrollo(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
    public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Videojuego> getLista_videojuego() {
		return lista_videojuego;
	}
	
}
