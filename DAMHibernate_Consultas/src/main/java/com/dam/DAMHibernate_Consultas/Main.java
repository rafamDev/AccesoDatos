package com.dam.DAMHibernate_Consultas;

import java.util.List;

import javax.persistence.Query;

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

		  session.getTransaction().begin();
		   
		   Query actores = session.createQuery("SELECT a FROM Actor AS a");
		   List<Actor> listaActores = actores.getResultList();
		   for (Actor actor : listaActores) {
			  System.out.println("Actor (ID): " + actor.getActorID());
			  System.out.println("Actor (Nombre): " + actor.getNombre());
		   }
		   
		   Query actores2 = session.createQuery("SELECT a.nombre FROM Actor AS a");
		   List<Object[]> listaActores2 = actores2.getResultList();
		   for (Object[] a : listaActores2) {
			   System.out.println("Actor (Nombre): " + (String)a[0]);
		   }
		   session.getTransaction().commit();

		   session.close();
		   sf.close();

	}

}
