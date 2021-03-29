package ejercicio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alumno {

   @Id
   private String id;
   @Column
   private String nombre;
   @Column
   private String tlfn;

   public Alumno(String id, String nombre, String tlfn) {
	 super();
	 this.id = id;
	 this.nombre = nombre;
	 this.tlfn = tlfn;
   }

   public String getId() {
	  return id;
   }

   public String getNombre() {
	  return nombre;
   }

   public String getTlfn() {
	  return tlfn;
   }
}
