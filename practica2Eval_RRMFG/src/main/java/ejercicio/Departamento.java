package ejercicio;

public class Departamento {
   
   private int codigoD;
   private String nombreDA;
   private String localidad;

   public Departamento(int codigoD, String nombreDA, String localidad) {
	 super();
	 this.codigoD = codigoD;
	 this.nombreDA = nombreDA;
	 this.localidad = localidad;
   }

   public int getCodigoD() {
	  return codigoD;
   }

   public String getNombreDA() {
	 return nombreDA;
   }

   public String getLocalidad() {
	 return localidad;
   }

   
}
