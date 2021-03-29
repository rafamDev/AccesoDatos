package ejercicio;

public class Main {

	public static void main(String[] args) {
		FicheroCSV ficheroCSV = new FicheroCSV();
		ConexionSQL conexionSQL = new ConexionSQL(ficheroCSV);
		conexionSQL.crearRegistros();
		  //Codigo y nombre de todos los videojuegos.
		  conexionSQL.setConsulta1();
		    ConexionNOSQL conexionNOSQL = new ConexionNOSQL(ficheroCSV);
		    conexionNOSQL.crearColeccionDesarrollo();
		    conexionNOSQL.crearColeccionVideojuego();
	     //Todos los datos de los videojuegos lanzados entre el 2010 y el 2016.
		 conexionNOSQL.setConsulta1();
		 //Borrar todos los videojuegos.
		 conexionNOSQL.setConsulta2();
	}

}
