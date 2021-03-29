package ejercicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConexionSQL {

private FicheroCSV ficheroCSV;
private StandardServiceRegistry sr;
private SessionFactory sf;
private Session session; 
	
	public ConexionSQL(FicheroCSV ficheroCSV){
		this.ficheroCSV = ficheroCSV;
		this.sr = new StandardServiceRegistryBuilder().configure().build();
		this.sf = new MetadataSources(this.sr).buildMetadata().buildSessionFactory();
	}

	public void crearRegistros() {
	   this.session = this.sf.openSession();
	   this.session.getTransaction().begin();
	        ArrayList<Desarrollo> lista_desarrollo = this.ficheroCSV.getLista_desarrollo();
	        ArrayList<Videojuego> lista_videojuegos = this.ficheroCSV.getLista_videojuego();
	        for (Desarrollo desarrollo : lista_desarrollo) {
            	session.save(desarrollo);
            }
		    for (Videojuego videojuego : lista_videojuegos) {
	    	    session.save(videojuego);
            }
	   this.session.getTransaction().commit();
	}
	
	public void setConsulta1(){
		this.session.getTransaction().begin();
		Query codigoVideojuegos = session.createQuery("SELECT c.codigo, c.nombre FROM Videojuego AS c");
		List<Object[]> listaCodigos = codigoVideojuegos.getResultList();
		   for (Object[] v : listaCodigos) {
			   System.out.println("\nVideojuego (Codigo): " + v[0].toString());
			   System.out.println("Videojuego (Nombre): " + v[1].toString());
		   }
		this.session.getTransaction().commit();
		this.session.close();  
		this.sf.close();  
	}

	
}
