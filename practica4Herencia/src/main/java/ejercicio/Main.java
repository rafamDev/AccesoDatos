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
		 //Lee el xml
		  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		  //Con la informacion del xml crea el sesion factory.
		  SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		  
		  //Abrimos la sesión
		  Session session = sf.openSession();

		  //Creamos los objetos que queremos mapear
		   Alumno al1 = new Alumno("1AA","Juanito", "686231785");
		   Alumno al2 = new Alumno("2BB","Pepe", "686437965");
		   Alumno al3 = new Alumno("3CC","Rafa", "624231585");
		   Ciclo asir = new Asir("AA1",al1,"Linux");
		   Ciclo dam = new Dam("BB2",al2,"Java");
		   Ciclo dam2 = new Dam("CC3",al3,"Python");
		  
		   //Iniciamos una transacción, hacemos persistentes los objetos, confirmamos la transacción y cerramos los objetos
		   session.getTransaction().begin();
		   session.save(al1);
		   session.save(al2); 
		   session.save(al3); 
		   session.save(asir);
		   session.save(dam);
		   session.save(dam2); 
		   setConsultas(session);
		   session.getTransaction().commit();

		   session.close();
		   sf.close();

	}

	private static void setConsultas(Session session) {
		Query alumnosIdNombre = session.createQuery("SELECT a.id, a.nombre FROM Alumno AS a");
		List<Object[]> listaAlumnos = (List<Object[]>) alumnosIdNombre.getResultList();
	    for (Object[] object : listaAlumnos) {
	    	 System.out.println("Id: " + object[0].toString() + 
	    			 " Nombre: " + object[1].toString());
		}
	  
		Query alumnos = session.createQuery("SELECT a FROM Alumno AS a");
		List<Alumno> listaAlumno = alumnos.getResultList();
		for (Alumno alumno : listaAlumno) {
			System.out.print("Id: " + alumno.getId() + " ");
			System.out.print("Nombre: " + alumno.getNombre() + " ");
			System.out.println("Telefono: " + alumno.getTlfn());
	    }
		
    }


}
