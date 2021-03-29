package ejercicio;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Cliente {

	@Id
	private int identificador;
	
	@ColumnTransformer(write = "MD5(?)")
	private String password;
	
	@CreationTimestamp
	private Timestamp fecha_alta;

	public Cliente(int identificador, String password) {
		super();
		this.identificador = identificador;
		this.password = password;
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getPassword() {
		return password;
	}

	public Timestamp getFecha_alta() {
		return fecha_alta;
	}
	
	
}
