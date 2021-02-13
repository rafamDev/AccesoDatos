package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Fichero_csv {

	private String gestor;
	private String driver; 
	
	public Fichero_csv(String gestor){
		this.gestor = gestor;
    }
	
	public String getDriver(){
		try {
			Path ruta = Paths.get("D:\\pruebas\\mapeo_JDBC_hibernate\\drivers.csv"); 
			BufferedReader br = Files.newBufferedReader(ruta);
			Stream<String> lineas = br.lines();
			lineas.forEach(cada_linea -> {
			  String [] parametro = cada_linea.split("=");
				if(parametro[0].equals("driver_" + this.gestor)){
				   this.driver = parametro[1];
				  }
		    });
			return this.driver;
		} catch (IOException e) {
			e.printStackTrace();
		}
	  return null;
	}
	
}
