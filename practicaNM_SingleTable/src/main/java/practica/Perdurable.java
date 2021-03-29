package practica;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Perdurable extends Mercancia {

   @Column	
   private LocalDate fecha_caducidad;

   public Perdurable(String codigo, String nombre, String origen, String destino, LocalDate fecha_caducidad) {
		super(codigo, nombre, origen, destino);
	  this.fecha_caducidad = fecha_caducidad;
   }

   public LocalDate getFecha_caducidad() {
	  return fecha_caducidad;
   }

}
