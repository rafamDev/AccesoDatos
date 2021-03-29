package ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conexion {

	private FicheroCSV ficheroCSV;
	
	public Conexion(FicheroCSV ficheroCSV){
		this.ficheroCSV = ficheroCSV;
	}

	public void crearTablasHibernate() {
	  StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();		
	    SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
	     Session session = sf.openSession();
	      session.getTransaction().begin();
	         ArrayList<Departamento> lista_departamento = this.ficheroCSV.getLista_departamento();
		    	for (Departamento departamento : lista_departamento) {
		    		session.save(departamento);
	            }
	          ArrayList<Empleado> lista_empleado = this.ficheroCSV.getLista_empleado();
			    for (Empleado empleado : lista_empleado) {
					session.save(empleado);
				}
	      session.getTransaction().commit();
		  session.close();  
	      sf.close();
	}
	
    public void consultar() {
	   Connection conexion = null;
	    Statement st = null;
	     String query="";
	       ResultSet rs = null;
	     try {
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/empresa","postgres","abc123");
			st = conexion.createStatement();
			query = "SELECT nombre FROM departamento";
			System.out.println("\n[DEPARTAMENTOS]:\n");
			  rs = st.executeQuery(query);
			   while(rs.next()){
				  System.out.println("Nombre: " + rs.getString("nombre"));  
                }
			rs.close();
			System.out.println("-------------------");
		    query = "SELECT * FROM empleado WHERE departamento=20";
		    System.out.println("\n[EMPLEADOS DE RRHH]:\n");
		    rs = st.executeQuery(query);
			   while(rs.next()){
				  System.out.println("Codigo: " + rs.getInt("codigo")
			                      + " \nNombre: " + rs.getString("nombre")  
			                      + " \nApellido: " + rs.getString("apellido")
				                  + " \nCargo: " + rs.getString("cargo")
						          + " \nNomina: " + rs.getInt("nomina")  
						          + " \nDepartamento: " + rs.getInt("departamento")); 
			    }
			rs.close();
			System.out.println("-------------------");
			st.close();
			conexion.close();
			
		 } catch (SQLException e) {
		     e.printStackTrace();
		 }
	   
	}


	
}
