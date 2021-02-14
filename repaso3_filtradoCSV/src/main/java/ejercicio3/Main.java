package ejercicio3;

public class Main {

	public static void main(String[] args) {
	   FicheroCSV ficheroCSV = new FicheroCSV(new Empleado());
	   ficheroCSV.getEmpleados_dep_10();
	   ficheroCSV.mostrarEmpleados_dep_10();
	}

}
