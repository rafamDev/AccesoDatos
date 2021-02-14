package ejercicio2;

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
	private ArrayList<Departamento> lista_departamento;
	private ArrayList<Empleado> lista_empleado;
	
	public FicheroXML() {
	   this.leerDepartamentos();
	   this.leerEmpleados();
	}
	
	private void leerDepartamentos() {
		try {
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = factory.newDocumentBuilder();
			this.documentoXML = this.builder.parse(new File("D:\\pruebas\\repaso\\ejecicio2.xml"));
		    NodeList nodo_departamento = this.documentoXML.getElementsByTagName("departamento");
		    NodeList codigo_departamento = this.documentoXML.getElementsByTagName("codigo_departamento");
			NodeList nombre_departamento = this.documentoXML.getElementsByTagName("nombre_departamento");
			NodeList loacalidad_departamento = this.documentoXML.getElementsByTagName("localidad_departamento");
			this.lista_departamento = new ArrayList<Departamento>();
		    for(int i=0; i < nodo_departamento.getLength(); i++) {
		        Departamento departamento = new Departamento();
		        departamento.setCodigo(Integer.parseInt(codigo_departamento.item(i).getTextContent()));
		        departamento.setNombre(nombre_departamento.item(i).getTextContent());
		        departamento.setLocalidad(loacalidad_departamento.item(i).getTextContent());
		        this.lista_departamento.add(departamento);
		    }
       } catch (ParserConfigurationException e) {
			e.printStackTrace();
	   } catch (SAXException e) {
		   e.printStackTrace();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
		
	}
	
	private void leerEmpleados() {
		try {
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = factory.newDocumentBuilder();
			this.documentoXML = this.builder.parse(new File("D:\\pruebas\\repaso\\ejecicio2.xml"));
		    NodeList nodo_empleado = this.documentoXML.getElementsByTagName("empleado");
		    NodeList codigo_empleado = this.documentoXML.getElementsByTagName("codigo_empleado");
			NodeList nombre_empleado = this.documentoXML.getElementsByTagName("nombre_empleado");
			NodeList apellido_empleado = this.documentoXML.getElementsByTagName("apellido_empleado");
			NodeList nomina_empleado = this.documentoXML.getElementsByTagName("nomina_empleado");
			NodeList departamento_empleado = this.documentoXML.getElementsByTagName("departamento_empleado");
			this.lista_empleado = new ArrayList<Empleado>();
		    for(int i=0; i < nodo_empleado.getLength(); i++) {
		        Empleado empleado = new Empleado();
		        empleado.setCodigo(Integer.parseInt(codigo_empleado.item(i).getTextContent()));
		        empleado.setNombre(nombre_empleado.item(i).getTextContent());
		        empleado.setApellido(apellido_empleado.item(i).getTextContent());
		        empleado.setNomina(Double.parseDouble(nomina_empleado.item(i).getTextContent()));
		        empleado.setDepartamento(Integer.parseInt(departamento_empleado.item(i).getTextContent()));
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

	public ArrayList<Departamento> getLista_departamento() {
		return lista_departamento;
	}

	public ArrayList<Empleado> getLista_empleado() {
		return lista_empleado;
	}



}
