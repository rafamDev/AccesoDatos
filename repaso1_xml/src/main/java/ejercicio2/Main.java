package ejercicio2;

public class Main {

	public static void main(String[] args) {
	  FicheroXML ficheroXML = new FicheroXML(new Conexion());
	  ficheroXML.crearFicheroXML();
	  ficheroXML.crearFicheroXML_Departamentos();
	  ficheroXML.crearFicheroXML_empleados();
	}

}
