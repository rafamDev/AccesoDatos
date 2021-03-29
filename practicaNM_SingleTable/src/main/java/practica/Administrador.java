package practica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Administrador {
    
	@Id
	private String codigo;
	
	@Column
	private String nombre;
	
	@ColumnTransformer(write = "MD5(?)")
	private String password;
	
	@Generated(GenerationTime.INSERT)
	@Column(columnDefinition = "VARCHAR(45) AS (CONCAT(codigo,' ',password))")
	private String login;

	@ManyToMany
	private List<Mercancia> lista_mercancias;
	
	public Administrador(String codigo, String nombre,String password) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.password = password;
		this.lista_mercancias = new ArrayList<Mercancia>();
	}

    public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public void addMercancia(Mercancia mercancia){
		this.lista_mercancias.add(mercancia);
	}
	
}
