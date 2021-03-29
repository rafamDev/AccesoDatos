package ejercicio;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

	public static void main(String[] args) {
		
		  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		 
		  SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		  
		  Session session = sf.openSession();

		  Cliente cliente1 = new Cliente(1,"cliente1");
		  Cliente cliente2 = new Cliente(2,"cliente2");
		  Cliente cliente3 = new Cliente(3,"cliente3");
		  Pedido pedido1 = new Pedido(1, cliente1);
		  Pedido pedido2 = new Pedido(2, cliente2);
		  Pedido pedido3 = new Pedido(3, cliente3);
		  Articulo articuloNormal1 = new Normal(1, "juego1", 20.00, 1);
		  Articulo articuloNormal2 = new Normal(2, "juego2", 10.95,2);
		  Articulo articuloPreventa = new Preventa(3, "juego3", 9.75);
		  pedido1.addArticulo(articuloNormal1);
		  pedido2.addArticulo(articuloNormal2);
		  pedido3.addArticulo(articuloPreventa);
		 
		   session.getTransaction().begin();
		   session.save(cliente1);
		   session.save(cliente2); 
		   session.save(cliente3); 
		   session.save(pedido1);
		   session.save(pedido2);
		   session.save(pedido3); 
		   session.save(articuloNormal1); 
		   session.save(articuloNormal2); 
		   session.save(articuloPreventa); 
	       setConsulta(session);
		   session.getTransaction().commit();
		  
	}

	private static void setConsulta(Session session) {
	    Query articuloNormal = session.createQuery("SELECT n FROM Articulo AS n WHERE DTYPE= :n");
		List<Normal> listaNormal = articuloNormal.setParameter("n", "normal").getResultList();
		System.out.println("\nARTICULOS NORMALES:");
		for (Normal normal: listaNormal) {
			System.out.print("Codigo: " + normal.getCodigo() + " ");
		    System.out.print("Nombre: " + normal.getNombre() + " ");
		    System.out.print("Precio: " + normal.getPrecio() + " ");
		    System.out.println("posicionVendidos: " + normal.getPosicionVendidos() + " ");
		}
	
	}

}
