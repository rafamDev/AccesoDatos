package ejercicio;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import java.util.List;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ConexionNOSQL {

	 private FicheroCSV ficheroCSV;
	 private MongoClient cliente;
	 private MongoDatabase db;
	 private MongoCollection<Document> coleccionDesarrollo; 
	 private MongoCollection<Document> coleccionVideojuego; 
	 
	 public ConexionNOSQL(FicheroCSV ficheroCSV){
		 this.ficheroCSV = ficheroCSV;
		 this.cliente = new MongoClient("localhost", 27017);
		 this.db = this.cliente.getDatabase("videojuegosmongo");
		 this.coleccionDesarrollo = this.db.getCollection("desarrollo");
		 this.coleccionVideojuego = this.db.getCollection("videojuego");
	 }
	 
	 public void crearColeccionDesarrollo(){
		List<Desarrollo> lista_desarrollo = this.ficheroCSV.getLista_desarrollo();
		    for (Desarrollo desarrollo : lista_desarrollo) {
		    	 Document nuevo_desarrollo = new Document();
		    	 nuevo_desarrollo.put("codigo", desarrollo.getCodigo());
			     nuevo_desarrollo.put("nombre", desarrollo.getNombre());
			     this.coleccionDesarrollo.insertOne(nuevo_desarrollo);
			}
	  }
	 
	 public void crearColeccionVideojuego(){
		 List<Videojuego> lista_videojuego = this.ficheroCSV.getLista_videojuego();
		 System.out.println(lista_videojuego.toString());
		     for (Videojuego videojuego : lista_videojuego) {
		    	  Document nuevo_videojuego = new Document();
			      nuevo_videojuego.put("codigo", videojuego.getCodigo());
			      nuevo_videojuego.put("nombre", videojuego.getNombre());
			      nuevo_videojuego.put("anho", videojuego.getAnho());
			      nuevo_videojuego.put("idDesarrollo", videojuego.getIdDesarrollo());
			      this.coleccionVideojuego.insertOne(nuevo_videojuego);
		      }
	  }

	 public void setConsulta1(){
		 MongoCursor<Document> iterador = this.coleccionVideojuego.find(and(gte("anho",2010), lte("anho",2016))).iterator();
           while(iterador.hasNext()){
        	   System.out.println(iterador.next());
           }
	 }
	 
	 public void setConsulta2(){
		 FindIterable<Document> videojuegos = this.coleccionVideojuego.find();
			for(Document videojuego: videojuegos) {
				this.coleccionVideojuego.deleteMany(videojuego);
			}
	 }
	 
}
