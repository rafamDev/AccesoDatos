package nm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.AdditionalJaxbMappingProducer;


public class Main {

	public static void main(String[] args) {
		 //Lee el xml
		  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		  //Con la informacion del xml crea el sesion factory.
		  SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		  
		  //Abrimos la sesión
		  Session session = sf.openSession();

		  //Creamos los objetos que queremos mapear
		  Pelicula pelicula1 = new Pelicula(1,"El bueno, el feo y el malo");
		  Pelicula pelicula2 = new Pelicula(2,"Nubes pasajeras");
		
		  Actor actor1 = new Actor(100,"Clint Eastwood");
		  Actor actor2 = new Actor(200,"Eli Wallach");
		  Actor actor3 = new Actor(300,"Kari Vanaenen");
		 
		  actor1.addMovie(pelicula1);
		  actor2.addMovie(pelicula1);
          actor3.addMovie(pelicula2);		  
		  
		   //Iniciamos una transacción, hacemos persistentes los objetos, confirmamos la transacción y cerramos los objetos
		   session.getTransaction().begin();
		   session.save(pelicula1);
		   session.save(pelicula2);
		   session.save(actor1);
		   session.save(actor2);
		   session.save(actor3);
		   session.getTransaction().commit();

		   session.close();
		   sf.close();

	}

}
