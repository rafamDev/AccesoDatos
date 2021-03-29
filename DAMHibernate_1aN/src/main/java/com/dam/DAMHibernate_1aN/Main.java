package com.dam.DAMHibernate_1aN;

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
			  Conductor conductor1 = new Conductor("11111111A", "Fulano", "688165323"); 
			  Coche coche1 = new Coche("4444ABC", "Ferrari", "F430",conductor1);
			  Coche coche2 = new Coche("8888CBA", "Seat", "Ibiza",conductor1);
			  Coche coche3 = new Coche("2222DBA", "Ford", "gt",conductor1);
			  
			  
			   //Iniciamos una transacción, hacemos persistentes los objetos, confirmamos la transacción y cerramos los objetos
			   session.getTransaction().begin();
			   session.save(coche1);
			   session.save(coche2);
			   session.save(coche3);
			   session.save(conductor1);
			   session.getTransaction().commit();

			   session.close();
			   sf.close();
	}

}
