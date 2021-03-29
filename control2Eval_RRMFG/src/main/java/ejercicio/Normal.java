package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Normal extends Articulo {

	@Column
    private int posicionVendidos;
	
    public Normal(int codigo, String nombre, double precio, int posicionVendidos) {
		super(codigo, nombre, precio);
		this.posicionVendidos = posicionVendidos;
	}

	public int getPosicionVendidos() {
		return posicionVendidos;
	}

    
}
