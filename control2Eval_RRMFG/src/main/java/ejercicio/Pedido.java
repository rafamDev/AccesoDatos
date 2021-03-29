package ejercicio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Pedido {

	@Id
	private int numero;
	
	@CreationTimestamp
	private Timestamp fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_cliente"))
	private Cliente cliente;
	
	@ManyToMany(fetch = FetchType.LAZY)
	List<Articulo> listaArticulos;

	public Pedido(int numero,Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.listaArticulos = new ArrayList<Articulo>();
	}

	public int getNumero() {
		return numero;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void addArticulo(Articulo articulo){
		this.listaArticulos.add(articulo);
	}
	
	
}
