package com.prueba.maven.cripto;

 import java.io.File;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
    import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerException;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	import org.w3c.dom.DOMImplementation;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.Text;
	 
  public class MyXml{
	  
	  private MyCrypAES cryp;
      private String path;
	
      public MyXml() {
        this.createXML();
	  }
	 
	  private void createXML() {
	     this.cryp = new MyCrypAES();
           this.path = "C:/Users/rafam/Desktop/ruta.xml";
	         try {
			   // Creo una instancia de DocumentBuilderFactory
			   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			   // Creo un documentBuilder
			   DocumentBuilder builder = factory.newDocumentBuilder();
			   // Creo un DOMImplementation
			   DOMImplementation implementation = builder.getDOMImplementation();
  	 
			   // Creo un documento con un elemento raiz
			   Document documento = implementation.createDocument(null, "path", null);
			   documento.setXmlVersion("1.0");
  	 
			    // Creo los elementos
			    Element datosBDD = documento.createElement("datosBDD");
			    Element ruta = documento.createElement("ruta");
  	 
			    // Location
			    Element location = documento.createElement("location");
			    Text textLocation = documento.createTextNode(this.cryp.getLocation());
			    location.appendChild(textLocation);
			    ruta.appendChild(location);
  	 
			    // User
			    Element user = documento.createElement("user");
			    Text textUser = documento.createTextNode(this.cryp.getUser());
			    user.appendChild(textUser);
			    ruta.appendChild(user);
  	 
			    // Password
			    Element password = documento.createElement("password");
			    Text textPassword = documento.createTextNode(this.cryp.getPassword());
			    password.appendChild(textPassword);
			    ruta.appendChild(password);
  	 
			    // Añado al elemento datosBDD el elemento ruta
			    datosBDD.appendChild(ruta);
  	 
			    // Añado al root el elemento coches
			    documento.getDocumentElement().appendChild(datosBDD);
  	 
			    // Asocio el source con el Document
			    DOMSource source = new DOMSource(documento);
			 
			    // Creo el Result, indicado que fichero se va a crear
			    StreamResult result = new StreamResult(new File(this.path));
			   
			    // Creo un transformer, se crea el fichero XML
			    Transformer transformer = TransformerFactory.newInstance().newTransformer();
			    transformer.transform(source, result);
			    
		    } catch (ParserConfigurationException | TransformerException ex) {
			    System.out.println(ex.getMessage());
			}
	      }

        public String getPath() {
			return path;
		}

}


