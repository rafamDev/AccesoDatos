package Main;

import ejercicio.Conexion;
import ejercicio.FicheroCSV;

public class Main {

	public static void main(String[] args) {
	  Conexion conexion = new Conexion(new FicheroCSV());
	  conexion.crearTablasHibernate();
	  conexion.consultar();
    }

}
