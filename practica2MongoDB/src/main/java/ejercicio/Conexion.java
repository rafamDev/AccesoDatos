package ejercicio;

import java.util.ArrayList;

import java.util.List;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Updates.*;


public class Conexion {

	 private Datos datos;
	 private MongoClient cliente;
	 private MongoDatabase db;
	 private MongoCollection<Document> coleccionJugadores; 
	 private MongoCollection<Document> coleccionEquipos; 
	 
	 public Conexion(Datos datos){
		 this.datos = datos;
		 this.cliente = new MongoClient("localhost", 27017);
		 this.db = cliente.getDatabase("deportes");
		 this.coleccionJugadores = db.getCollection("jugadores");
		 this.coleccionEquipos = db.getCollection("equipos");
	 }
	 
	 public void crearColeccionJugadores(){
		 List<Jugador> lista_jugadores = this.datos.getLista_jugadores();
		     for (Jugador jugador : lista_jugadores) {
		    	  Document nuevo_juagdor = new Document();
			      nuevo_juagdor.put("codigo", jugador.getCodigo());
			      nuevo_juagdor.put("nombre", jugador.getNombre());
			      nuevo_juagdor.put("edad", jugador.getEdad());
			      nuevo_juagdor.put("codEquipo", jugador.getCodigoEquipo());
			      this.coleccionJugadores.insertOne(nuevo_juagdor);
		      }
	  }
	 
	 public void crearColeccionEquipos(){
		 List<Equipo> lista_equipos = this.datos.getLista_equipos();
		     for (Equipo equipo : lista_equipos) {
		    	  Document nuevo_equipo = new Document();
			      nuevo_equipo.put("codigo", equipo.getCodigo());
			      nuevo_equipo.put("nombreEquipo", equipo.getNombreEquipo());
			      nuevo_equipo.put("anhoFundacion", equipo.getAnhoFundacion());
			      this.coleccionEquipos.insertOne(nuevo_equipo);
		      }
      }
	 
	 public void setConsulta1(){
	   List<Document> jugadores = this.coleccionJugadores.find().into(new ArrayList<Document>());
		 for (Document doc: jugadores) {
		    System.out.println("Nombre Jugador: " + doc.getString("nombre"));
		 }
     }
	 
	 public void setConsulta2(){
		List<Document> equipos = this.coleccionEquipos.find(and(lt("anhoFundacion", 2005), gt("anhoFundacion", 1950)))
		   .projection(include("nombreEquipo"))
			  .into(new ArrayList<Document>());
	              for(Document doc : equipos){
	    	            System.out.println("Nombre de equipo/s fundados entre 1950 y 2005: " + doc.getString("nombreEquipo"));
	                 }
     }
	 
	 public void setConsulta3(){
		DeleteResult jugador300 = this.coleccionJugadores.deleteMany(eq("codEquipo",300));
		  System.out.println("Se han eliminado : " + jugador300.getDeletedCount() + " jugadores, con codigo 300" );
	 }
	 
	 public void setConsulta4(){
		UpdateResult equipo20 = this.coleccionEquipos.updateOne(eq("codigo", 20), set("nombreEquipo","DEP"));
		  System.out.println("Se ha modificado: " + equipo20.getModifiedCount() + " equipo, con codigo 20");
     }
}
