package practica;

import org.bson.Document;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;


public class Main {

	public static void main(String[] args) {
		 MongoClient cliente = new MongoClient("localhost", 27017);
		 MongoDatabase db = cliente.getDatabase("dam");
		 MongoCollection<Document> coleccion = db.getCollection("alumnos");
		 //insertarAlumnos(coleccion);
		 MongoCursor<Document> iterator = coleccion.find().iterator();
		   while(iterator.hasNext()){
			   System.out.println(iterator.next());
		   }
		 iterator.close();
	}

	private static void insertarAlumnos(MongoCollection<Document> coleccion) {
		Document nuevo_alumno = new Document();
		nuevo_alumno.put("nombre", "Javier");
		nuevo_alumno.put("edad", 22);
		nuevo_alumno.put("ciclo", "2DAM");
		coleccion.insertOne(nuevo_alumno);
		Document nuevo_alumno2 = new Document();
		nuevo_alumno2.put("nombre", "Mengano");
		nuevo_alumno2.put("edad", 42);
		nuevo_alumno2.put("ciclo", "1DAM");
		coleccion.insertOne(nuevo_alumno2);
		Document nuevo_alumno3 = new Document();
		nuevo_alumno3.put("nombre", "Manolo");
		nuevo_alumno3.put("edad", 31);
		nuevo_alumno3.put("ciclo", "1DAM");
		coleccion.insertOne(nuevo_alumno3);
    }
 
}
