package practica;

import java.sql.Timestamp;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Perecedera extends Mercancia {

    @CreationTimestamp
	private Timestamp fecha_caducidad;
    
    public Perecedera(String codigo, String nombre, String origen, String destino) {
		super(codigo, nombre, origen, destino);
	}

	public Timestamp getFecha_caducidad() {
		return fecha_caducidad;
	}

    
}
