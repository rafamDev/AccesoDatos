package com.prueba.maven.cripto;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyReadXML {
 
	private MyXml xml;
	
	public MyReadXML(MyXml xml) {
	   this.xml = xml;
	     this.readXML();
	}		
	 
	private void readXML() {
	   try {
          // Creo una instancia de DocumentBuilderFactory
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          
          // Creo un documentBuilder
          DocumentBuilder builder = factory.newDocumentBuilder();

          // Obtengo el documento, a partir del XML
          Document documento = builder.parse(new File(this.xml.getPath()));

          // Cojo todas las etiquetas del documento
          NodeList ruta = documento.getElementsByTagName("ruta");

	       // Recorro las etiquetas
          for (int i = 0; i < ruta.getLength(); i++) {
              // Cojo el nodo actual
              Node nodo = ruta.item(i);
              // Compruebo si el nodo es un elemento
              if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                  // Lo transformo a Element
                  Element e = (Element) nodo;
                  // Obtengo sus hijos
                  NodeList hijos = e.getChildNodes();
        
                  // Recorro sus hijos
                  for (int j = 0; j < hijos.getLength(); j++) {
                      // Obtengo al hijo actual
                      Node hijo = hijos.item(j);
                  
                      // Compruebo si es un nodo
                      if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                          // Muestro el contenido
                    	System.out.println("Propiedad: " + "[" + hijo.getNodeName() + "]"
                                   + ", Valor: " + hijo.getTextContent());
                                 
                      }

                  }
                  
              }

          }

      } catch (Exception ex) {
          System.out.println(ex.getMessage());
      }
  
   }

	
 }
