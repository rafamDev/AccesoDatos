package com.dam.DAMHibernate_CamposDerivados;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String args[]){
      //Lee el xml
  	  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
  	  //Con la informacion del xml crea el sesion factory.
  	  SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
  	  
  	  //Abrimos la sesión
  	  Session session = sf.openSession();

  	  //Creamos los objetos que queremos mapear
  	  Usuario user1 = new Usuario("Josito", "per97gn"); 
  	  Usuario user2 = new Usuario("pepito", "pe2unmgn"); 
  	  
  	   //Iniciamos una transacción, hacemos persistentes los objetos, confirmamos la transacción y cerramos los objetos
  	   session.getTransaction().begin();
  	   session.save(user1);
  	   session.save(user2);
  	   session.getTransaction().commit();

  	   session.close();
  	   sf.close();
    }
}
