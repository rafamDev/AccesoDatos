package ejercicio;

public class Main {

	public static void main(String[] args) {
		Conexion conexion = new Conexion(new Datos(new FicheroCSV()));
        conexion.crearColeccionJugadores();
        conexion.crearColeccionEquipos();
        conexion.setConsulta1();
        conexion.setConsulta2();
        conexion.setConsulta3();
        conexion.setConsulta4();
	}

}
