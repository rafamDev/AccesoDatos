package ejercicio;

public class Departamento {
   
   private int codigoD;
   private String nombreD;
   private String localidad;

   public Departamento(int codigoD, String nombreD, String localidad) {
	 super();
	 this.codigoD = codigoD;
	 this.nombreD = nombreD;
	 this.localidad = localidad;
   }

   public int getCodigoD() {
	  return codigoD;
   }

   public String getNombreD() {
	 return nombreD;
   }

   public String getLocalidad() {
	 return localidad;
   }


   
}
