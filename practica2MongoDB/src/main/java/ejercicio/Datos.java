package ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Datos {

	private ArrayList<Jugador> lista_jugadores;
	private ArrayList<Equipo> lista_equipos;
	private Path ruta;
	private BufferedReader br;
	private Stream<String>lineas;
	private FicheroCSV ficheroCSV;
	
	public Datos(FicheroCSV ficheroCSV){
	   this.ficheroCSV = ficheroCSV;	
	   this.leerEquipos();
	   this.leerJugadores();
	}

    private void leerJugadores() {
    	try {
			this.lista_jugadores = new ArrayList<Jugador>();
			this.ruta = Paths.get(this.ficheroCSV.getRuta("jugadores"));
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lineas.forEach(cada_linea ->{
				String parametro[] = cada_linea.split(";"); 
				this.lista_jugadores.add(new Jugador(Integer.parseInt(parametro[0]),
						parametro[1],Integer.parseInt(parametro[2]),Integer.parseInt(parametro[3])));
						
			});
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

    private void leerEquipos() {
    	try {
			this.lista_equipos = new ArrayList<Equipo>();
			this.ruta = Paths.get(this.ficheroCSV.getRuta("equipos"));
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lineas.forEach(cada_linea ->{
				String parametro[] = cada_linea.split(";"); 
				this.lista_equipos.add(new Equipo(Integer.parseInt(parametro[0]),
						parametro[1],Integer.parseInt(parametro[2])));
						
			});
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	public ArrayList<Jugador> getLista_jugadores() {
		return lista_jugadores;
	}

	public ArrayList<Equipo> getLista_equipos() {
		return lista_equipos;
	}
	
	
}
