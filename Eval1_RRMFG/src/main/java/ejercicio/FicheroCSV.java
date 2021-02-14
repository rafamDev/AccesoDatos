package ejercicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FicheroCSV {

	private FicheroXML ficheroXML;
	private File csv;
    private BufferedWriter br;
	   
	   public FicheroCSV(FicheroXML ficheroXML) {
		   this.ficheroXML = ficheroXML;
	   }

	   public void crearCSV() {
		 try {
			this.csv = new File("D:\\pruebas\\RRMFG.csv");
			this.csv.createNewFile();
			this.br = new BufferedWriter(new FileWriter("D:\\pruebas\\RRMFG.csv"));
			 this.br.write("--AUTORES--\n");
			 ArrayList<Autor> lista_autor = this.ficheroXML.getLista_autor();
			  for (Autor autor : lista_autor) {
				this.br.write(autor.getCodigo() + "," + autor.getNombre() + "," + autor.getPais()+ "\n");
		      }
			  this.br.write("--LIBROS--\n");
				 ArrayList<Libro> lista_libro = this.ficheroXML.getLista_libro();
				  for (Libro libro : lista_libro) {
					this.br.write(libro.getIsbn() + "," + libro.getTitulo() + "," + libro.getEditorial() + "," + libro.getCodigo_autor() + "\n");
			      }
			  this.br.flush();
			  this.br.close();
		 } catch (IOException e) {
		   e.printStackTrace();
		 }
      }
}
