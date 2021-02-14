package ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conexion {

	private FicheroXML ficheroXML;
	
	public Conexion(FicheroXML ficheroXML){
		this.ficheroXML = ficheroXML;
	}

	public void crearAutores_Hibernate() {
	  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();		
	    SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
	     Session session = sf.openSession();
	      session.getTransaction().begin();
	         ArrayList<Autor> lista_autor = this.ficheroXML.getLista_autor();
		    	for (Autor autor : lista_autor) {
		    		session.save(autor);
	            }
          session.getTransaction().commit();
		  session.close();  
	      sf.close();
     }

	public void crearLibros_JDBC(){
	 Connection con = null;
	 PreparedStatement ps = null;
	 Statement st = null;
	 String createTable = "CREATE TABLE libro" 
		        +"(isbn VARCHAR(255) NOT NULL,"
                +"titulo VARCHAR(45) NOT NULL,"
		        +"editorial VARCHAR(45) NOT NULL," 
		        +"codigo_autor INTEGER(3) NOT NULL,"
                +"PRIMARY KEY(isbn) " + ")";
	 String insert = "INSERT INTO libro(isbn,titulo,editorial,codigo_autor) VALUES(?,?,?,?)";
		try {
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Eval1?useSSL=false&serverTimezone=Europe/Madrid","root","abc123");
			st = con.createStatement();
			st.execute("DROP TABLE IF EXISTS libro");
			st.execute(createTable);
			st.close();
			ps = con.prepareStatement(insert);
			ArrayList<Libro> lista_libro = this.ficheroXML.getLista_libro();
			for(int i=0; i < lista_libro.size(); i++) {
				ps.setString(1, lista_libro.get(i).getIsbn());
				ps.setString(2, lista_libro.get(i).getTitulo());
				ps.setString(3, lista_libro.get(i).getEditorial());
				ps.setInt(4, lista_libro.get(i).getCodigo_autor());
				ps.executeUpdate();
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
      }


}
