package practica;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

	public static void main(String[] args) {
		 //Lee el xml
		  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		  //Con la informacion del xml crea el sesion factory.
		  SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		  
		  //Abrimos la sesión
		  Session session = sf.openSession();

		  //Creamos los objetos que queremos mapear
		   Administrador administrador1 = new Administrador("1AA", "Mengano","abcd1234");
		   Administrador administrador2 = new Administrador("2BB", "Fulano","1234abcd");
		   Mercancia mercancia1 = new Perecedera("AA1","Fruta","PON","VAL");
		   Mercancia mercancia2 = new Perecedera("AA2","Verduras","LUG","MAL");
		   Mercancia mercancia3 = new Perdurable("BB1","Conservas","AC","BCN",LocalDate.now());
		   Mercancia mercancia4 = new Perdurable("BB2","Cosmeticos","MDZ","SEV",LocalDate.now());
		   administrador1.addMercancia(mercancia1);
		   administrador1.addMercancia(mercancia2);
		   administrador2.addMercancia(mercancia3);
		   administrador2.addMercancia(mercancia4);
		  
		  //Iniciamos una transacción, hacemos persistentes los objetos, confirmamos la transacción y cerramos los objetos
		   session.getTransaction().begin();
		   session.save(administrador1);
		   session.save(administrador2);
		   session.save(mercancia1);
		   session.save(mercancia2);
		   session.save(mercancia3);
		   session.save(mercancia4);
		   setConsultas(session);
		   session.getTransaction().commit();

		   session.close();
		   sf.close();

	}

	private static void setConsultas(Session session) {
		//Todas las mercancias perecederas.
		Query perecederas = session.createQuery("SELECT p FROM Mercancia AS p WHERE DTYPE= :mp");
		List<Perecedera> listaPerecedera = perecederas.setParameter("mp", "perecedera").getResultList();
	    System.out.println("\nMERCANCIAS PERECEDERAS:");
		for (Perecedera perecedera : listaPerecedera) {
			System.out.print("Codigo: " + perecedera.getCodigo() + " ");
			System.out.print("Nombre: " + perecedera.getNombre() + " ");
			System.out.print("origen: " + perecedera.getOrigen() + " ");
			System.out.print("Destino: " + perecedera.getDestino() + " ");
			System.out.println("Fec/Caducidad: " + perecedera.getFecha_caducidad());
		}
		System.out.println("");
		
		//Nombre y fecha de caducidad de las mercancias que vengan de Lugo.
		Query mercancias = session.createQuery("SELECT m.nombre, m.fecha_caducidad FROM Mercancia AS m WHERE origen= :l");
		List<Object[]> listaMercancias = (List<Object[]>) mercancias.setParameter("l", "LUG").getResultList();
	    System.out.println("\nMERCANCIAS DE LUGO:");
	    for (Object[] objects : listaMercancias) {
			System.out.print("Nombre: " + objects[0].toString() + " ");
			System.out.println("Fecha/Caducidad: " + objects[1].toString());
		}
		System.out.println("");
   }
    
}
