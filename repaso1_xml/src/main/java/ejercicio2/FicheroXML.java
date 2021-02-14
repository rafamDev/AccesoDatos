package ejercicio2;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.xml.bind.v2.schemagen.xmlschema.TypeDefParticle;

public class FicheroXML {
	private Conexion conexion;
	private ArrayList<Departamento> lista_departamento;
	private ArrayList<Empleado> lista_empleado;
	private Document document;
	private Element element;
	
	public FicheroXML(Conexion conexion){
		this.conexion = conexion;
	}
	
    public void crearFicheroXML(){
    	try {
    	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 	      DocumentBuilder builder = factory.newDocumentBuilder();
 		  this.document = builder.newDocument();
 		    this.element = this.document.createElement("empresa");
			this.document.appendChild(this.element);
			 crearDepartamentos();
			 crearEmpleados();
			   TransformerFactory tf = TransformerFactory.newInstance();
			   Transformer transformer = tf.newTransformer();
			   DOMSource source = new DOMSource(this.document);
			   StreamResult result = new StreamResult(new File("D:\\pruebas\\repaso\\ejecicio2.xml"));
			   transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			
		} catch (TransformerException e2) {
		   e2.printStackTrace();
	    }
    	  
	}

    public void crearFicheroXML_Departamentos(){
    	try {
    	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 	      DocumentBuilder builder = factory.newDocumentBuilder();
 		  this.document = builder.newDocument();
 		    this.element = this.document.createElement("empresa");
			this.document.appendChild(this.element);
			 crearDepartamentos();
			   TransformerFactory tf = TransformerFactory.newInstance();
			   Transformer transformer = tf.newTransformer();
			   DOMSource source = new DOMSource(this.document);
			   StreamResult result = new StreamResult(new File("D:\\pruebas\\repaso\\ejecicio2_departamentos.xml"));
			   transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			
		} catch (TransformerException e2) {
		   e2.printStackTrace();
	    }
    	  
	}
    
    public void crearFicheroXML_empleados(){
    	try {
    	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 	      DocumentBuilder builder = factory.newDocumentBuilder();
 		  this.document = builder.newDocument();
 		    this.element = this.document.createElement("empresa");
			this.document.appendChild(this.element);
			crearEmpleados();
			   TransformerFactory tf = TransformerFactory.newInstance();
			   Transformer transformer = tf.newTransformer();
			   DOMSource source = new DOMSource(this.document);
			   StreamResult result = new StreamResult(new File("D:\\pruebas\\repaso\\ejecicio2_empleados.xml"));
			   transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			
		} catch (TransformerException e2) {
		   e2.printStackTrace();
	    }
    	  
	}
    
    private void crearDepartamentos() {
	  this.lista_departamento= this.conexion.getLista_departamento();
	  Element departamentos = this.document.createElement("departamentos");
	  this.element.appendChild(departamentos);
	    for(int i = 0; i < this.lista_departamento.size(); i++){
		    Element departamento = this.document.createElement("departamento");
		    departamentos.appendChild(departamento);
		    Element codigo = this.document.createElement("codigo_departamento");
			departamento.appendChild(codigo);
			Element nombre = this.document.createElement("nombre_departamento");
			departamento.appendChild(nombre);
			Element localidad = this.document.createElement("localidad_departamento");
			departamento.appendChild(localidad);
			  codigo.setTextContent("" + this.lista_departamento.get(i).getCodigo());
		      nombre.setTextContent(this.lista_departamento.get(i).getNombre());
		      localidad.setTextContent(this.lista_departamento.get(i).getLocalidad()); 
		   } 
		
	}
	
	private void crearEmpleados() {
	   this.lista_empleado = this.conexion.getLista_empleado();
	   Element empleados = this.document.createElement("empleados");
	   this.element.appendChild(empleados);
	     for(int i = 0; i < this.lista_empleado.size(); i++){
		     Element empleado = this.document.createElement("empleado");
		     empleados.appendChild(empleado);
		       Element codigo = this.document.createElement("codigo_empleado");
			   empleado.appendChild(codigo);
			   Element nombre = this.document.createElement("nombre_empleado");
			   empleado.appendChild(nombre);
			   Element apellido = this.document.createElement("apellido_empleado");
			   empleado.appendChild(apellido);
			   Element nomina = this.document.createElement("nomina_empleado");
		       empleado.appendChild(nomina);
		       Element departamento = this.document.createElement("departamento_empleado");
		       empleado.appendChild(departamento);
		      	  codigo.setTextContent("" + this.lista_empleado.get(i).getCodigo());
				  nombre.setTextContent(this.lista_empleado.get(i).getNombre());
				  apellido.setTextContent(this.lista_empleado.get(i).getApellido()); 
				  apellido.setTextContent(this.lista_empleado.get(i).getCargo()); 
				  nomina.setTextContent("" + this.lista_empleado.get(i).getNomina());
				  departamento.setTextContent("" + this.lista_empleado.get(i).getDepartamento());
			} 
     }


}
