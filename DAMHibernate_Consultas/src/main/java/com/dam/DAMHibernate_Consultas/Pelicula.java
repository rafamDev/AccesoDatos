package com.dam.DAMHibernate_Consultas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pelicula {
   @Id
   private int peliculaID;	
   @Column
   private String titulo;

   public Pelicula(int peliculaID, String titulo) {
	 super();
	 this.peliculaID = peliculaID;
	 this.titulo = titulo;
   }
   
   public int getPeliculaID() {
	  return peliculaID;
   }

   public void setPeliculaID(int peliculaID) {
	  this.peliculaID = peliculaID;
   }

   public String getTitulo() {
	 return titulo;
   }

   public void setTitulo(String titulo) {
	 this.titulo = titulo;
   }
   
   
   
}
