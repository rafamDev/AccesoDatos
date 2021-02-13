package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pojo.Empleado;
import pojo.Jefe;

public class Fichero_xml {

	private ArrayList<Jefe> lista_jefe;
	private ArrayList<Empleado> lista_empleado;
	
	public Fichero_xml() {
	   this.leerFicheroXML();
	}
	
	private void leerFicheroXML(){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder	builder = factory.newDocumentBuilder();
			Document documentoXML = builder.parse(new File("D:\\pruebas\\mapeo_JDBC_hibernate\\departamento.xml"));
		    NodeList nodo_jefe = documentoXML.getElementsByTagName("jefe");
			NodeList codigo_jefe = documentoXML.getElementsByTagName("codigo_jefe");
			NodeList nombre_jefe = documentoXML.getElementsByTagName("nombre_jefe");
			NodeList apellido_jefe = documentoXML.getElementsByTagName("apellido_jefe");
			NodeList nomina_jefe = documentoXML.getElementsByTagName("nomina_jefe");
			 this.lista_jefe = new ArrayList<Jefe>();
		      for(int i=0; i < nodo_jefe.getLength(); i++) {
		    	 Jefe jefe = new Jefe();
		    	 jefe.setCodigo_jefe(Integer.parseInt(codigo_jefe.item(i).getTextContent()));
		         jefe.setNombre_jefe(nombre_jefe.item(i).getTextContent());
		         jefe.setApellido_jefe(apellido_jefe.item(i).getTextContent());
		         jefe.setNomina_jefe(Double.parseDouble(nomina_jefe.item(i).getTextContent()));
		         this.lista_jefe.add(jefe);
		      }
			NodeList nodo_empleado = documentoXML.getElementsByTagName("empleado");
			NodeList codigo_empleado = documentoXML.getElementsByTagName("codigo_empleado");
			NodeList nombre_empleado = documentoXML.getElementsByTagName("nombre_empleado");
			NodeList apellido_empleado = documentoXML.getElementsByTagName("apellido_empleado");
			NodeList nomina_empleado = documentoXML.getElementsByTagName("nomina_empleado");
			 this.lista_empleado = new ArrayList<Empleado>();
			  for(int i=0; i < nodo_empleado.getLength(); i++) {
			     Empleado empleado = new Empleado();
			     empleado.setCodigo_empleado(Integer.parseInt(codigo_empleado.item(i).getTextContent()));
			     empleado.setNombre_empleado(nombre_empleado.item(i).getTextContent());
			     empleado.setApellido_empleado(apellido_empleado.item(i).getTextContent());
			     empleado.setNomina_empleado(Double.parseDouble(nomina_empleado.item(i).getTextContent()));
			     this.lista_empleado.add(empleado);
			  }
		
		} catch (ParserConfigurationException e) {
		    e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Jefe> getLista_jefe() {
		return lista_jefe;
	}

	public ArrayList<Empleado> getLista_empleado() {
		return lista_empleado;
	}
	
	
}
