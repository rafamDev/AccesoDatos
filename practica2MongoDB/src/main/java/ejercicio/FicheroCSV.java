package ejercicio;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FicheroCSV {

    private File csv;
	private BufferedWriter br;
	
	public FicheroCSV(){
		crearEquipos();
		crearJugadores();
	}

	private void crearJugadores() {
	   try {
		 this.csv = new File(this.getRuta("jugadores"));
		 this.csv.createNewFile();
		 this.br = new BufferedWriter(new FileWriter(this.getRuta("jugadores")));
		    this.br.write("10;Fulano;18;300\n" + "30;Mengano;28;100\n" + "50;Pepito;21;400\n" + "20;Josete;24;300\n");
			this.br.flush();
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
	    }
	}

	private void crearEquipos() {
	  try {
		this.csv = new File(this.getRuta("equipos"));
		this.csv.createNewFile();
		this.br = new BufferedWriter(new FileWriter(this.getRuta("equipos")));
		    this.br.write("100;FCB;1940\n" + "300;RMA;1902\n" + "20;ACM;1960\n" + "400;RSA;2007\n");
			this.br.flush();
			this.br.close();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	public String getRuta(String fichero){
		return "D:\\pruebas\\repaso\\csv_" + fichero + ".csv";
	}
}
