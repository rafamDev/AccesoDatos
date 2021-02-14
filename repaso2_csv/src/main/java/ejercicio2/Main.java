package ejercicio2;

public class Main {

	public static void main(String[] args) {
		FicheroCSV fichero_csv = new FicheroCSV(new FicheroXML());
		fichero_csv.crearDepartamentos();
		fichero_csv.crearEmpleados();
     }

}
