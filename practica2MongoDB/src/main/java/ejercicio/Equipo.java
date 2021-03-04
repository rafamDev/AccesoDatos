package ejercicio;

public class Equipo {
   
   private int codigo;
   private String nombreEquipo;
   private int anhoFundacion;
   
   public Equipo(int codigo, String nombreEquipo, int anhoFundacion) {
	 super();
	 this.codigo = codigo;
	 this.nombreEquipo = nombreEquipo;
	 this.anhoFundacion = anhoFundacion;
   }
   
   public int getCodigo() {
	  return codigo;
   }

   public String getNombreEquipo() {
	   return nombreEquipo;
   }

   public int getAnhoFundacion() {
	   return anhoFundacion;
   }

}
