package ejercicio;

public class Main {

	public static void main(String[] args) {
	   Conexion conexion = new Conexion(new FicheroXML());
	   conexion.crearAutores_Hibernate();
	   conexion.crearLibros_JDBC();
	   FicheroCSV ficheroCSV = new FicheroCSV(new FicheroXML());
	   ficheroCSV.crearCSV();
    }

}
