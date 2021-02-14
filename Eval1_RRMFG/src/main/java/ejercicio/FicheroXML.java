package ejercicio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FicheroXML {
	private DocumentBuilderFactory factory;
	private DocumentBuilder	builder;
	private Document documentoXML;
	private ArrayList<Autor> lista_autor;
	private ArrayList<Libro> lista_libro;
	
	public FicheroXML() {
	   this.leerAutores();
	   this.leerLibros();
	}
	
	private void leerAutores() {
		try {
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = factory.newDocumentBuilder();
			this.documentoXML = this.builder.parse(new File("D:\\pruebas\\biblioteca.xml"));
			NodeList autor = this.documentoXML.getElementsByTagName("Autor");
			NodeList codigo = this.documentoXML.getElementsByTagName("Codigo");
		    NodeList nombre = this.documentoXML.getElementsByTagName("Nombre");
			NodeList pais = this.documentoXML.getElementsByTagName("Pais");
			this.lista_autor = new ArrayList<Autor>();
		    for(int i=0; i < autor.getLength(); i++) {
		     this.lista_autor.add(new Autor(Integer.parseInt(codigo.item(i).getTextContent()), nombre.item(i).getTextContent(),pais.item(i).getTextContent()));
		    }
		  
       } catch (ParserConfigurationException e) {
			e.printStackTrace();
	   } catch (SAXException e) {
		   e.printStackTrace();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
		
	}
	
	private void leerLibros() {
		try {
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = factory.newDocumentBuilder();
			this.documentoXML = this.builder.parse(new File("D:\\pruebas\\biblioteca.xml"));
		    NodeList libro = this.documentoXML.getElementsByTagName("Libro");
		    NodeList isbn = this.documentoXML.getElementsByTagName("ISBN");
			NodeList titulo = this.documentoXML.getElementsByTagName("Titulo");
			NodeList editorial = this.documentoXML.getElementsByTagName("Editorial");
			NodeList codAutor = this.documentoXML.getElementsByTagName("CodAutor");
			this.lista_libro = new ArrayList<Libro>();
		    for(int i=0; i < libro.getLength(); i++) {
		     this.lista_libro.add(new Libro(isbn.item(i).getTextContent(),titulo.item(i).getTextContent(), editorial.item(i).getTextContent(),Integer.parseInt(codAutor.item(i).getTextContent())));
		    }
		    
       } catch (ParserConfigurationException e) {
			e.printStackTrace();
	   } catch (SAXException e) {
		   e.printStackTrace();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
		
	}

	public ArrayList<Autor> getLista_autor() {
		return lista_autor;
	}

	public ArrayList<Libro> getLista_libro() {
		return lista_libro;
	}
}
