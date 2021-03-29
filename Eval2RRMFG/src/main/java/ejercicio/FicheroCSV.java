package ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FicheroCSV {

	private Path ruta;
	private BufferedReader br;
	private Stream<String>lineas;
    private ArrayList<Videojuego> lista_videojuego;
    private ArrayList<Desarrollo> lista_desarrollo; 
   
	
	public FicheroCSV(){
		this.leerDesarrollos();
	    this.leerVideojuegos();
	}

	private void leerDesarrollos() {
		try {
			this.lista_desarrollo = new ArrayList<Desarrollo>();
			this.ruta = Paths.get("D:\\pruebas\\desarrollo.csv");
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lineas.forEach(cada_linea ->{
				String parametro[] = cada_linea.split(",");
				this.lista_desarrollo.add(new Desarrollo(Integer.parseInt(parametro[0]),parametro[1]));
			});
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	private void leerVideojuegos() {
		try {
			this.lista_videojuego = new ArrayList<Videojuego>();
			this.ruta = Paths.get("D:\\pruebas\\videojuegos.csv");
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lineas.forEach(cada_linea ->{
			String parametro[] = cada_linea.split(","); 
			     this.lista_videojuego.add(new Videojuego(Integer.parseInt(parametro[0]),parametro[1],
					Integer.parseInt(parametro[2]),Integer.parseInt(parametro[3])));	
			});
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	public ArrayList<Desarrollo> getLista_desarrollo() {
		return lista_desarrollo;
	}
	

	public ArrayList<Videojuego> getLista_videojuego() {
		return lista_videojuego;
	}
	
}
