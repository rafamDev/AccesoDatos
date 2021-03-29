package com.dam.DAMHibernate_Consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Actor {
    
	@Id
    private int actorID;
    @Column
	private String nombre;
	
   // @ManyToMany(fetch = FetchType.LAZY)
   // private List<Pelicula> peliculas;
    
	public Actor(int actorID, String nombre) {
		super();
		this.actorID = actorID;
		this.nombre = nombre;
		//this.peliculas = new ArrayList<Pelicula>();
	}
	
	public Actor() {}

	public int getActorID() {
		return actorID;
	}
	
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*public void addMovie(Pelicula pelicula){
	   this.peliculas.add(pelicula);	
	}*/
   
}
