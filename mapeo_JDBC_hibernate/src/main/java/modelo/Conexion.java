package modelo;

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
import controlador.Fichero_csv;
import controlador.Fichero_properties;
import controlador.Fichero_xml;
import pojo.Empleado;
import pojo.Jefe;

public class Conexion {
     
	private String gestor;
	private Connection conexion;
	private String query;
	private String puesto;
	private Fichero_xml fichero_xml;
	private Fichero_csv fichero_csv;
	private Fichero_properties fichero_properties; 
	
	public Conexion(String gestor){
		this.gestor = gestor;
		this.fichero_xml = new Fichero_xml();
		this.fichero_csv = new Fichero_csv(gestor);
		this.fichero_properties = new Fichero_properties(gestor);
	}
	
	public void crearTablaJDBC(String puesto){
	   this.puesto = puesto;
	   this.conexion = null;
	      Statement st = null;
		  try {
			Class.forName(this.fichero_csv.getDriver());
			this.conexion = DriverManager.getConnection(this.fichero_properties.getBdd(),this.fichero_properties.getUsuario(),this.fichero_properties.getPassword());
			st = this.conexion.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS " + this.puesto);
			st.executeUpdate(this.getQuery());
			st.close();
			this.conexion.close();
			System.out.println("[Tablas creadas con JDBC (" + this.gestor + ")]");
			this.crearRegistros();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	 }
	
	 private String getQuery() {
		if(this.gestor.equals("mysql")){
		      this.query ="CREATE TABLE " + this.puesto 
			        +"(codigo_" + this.puesto + " INTEGER NOT NULL,"
                    +"nombre_" + this.puesto + " VARCHAR(45) NOT NULL,"
			        +"apellido_" + this.puesto + " VARCHAR(45) NOT NULL," 
			        +"nomina_" + this.puesto + " DOUBLE NOT NULL,"
                    +"PRIMARY KEY( codigo_" + this.puesto +")" + ")";
			return this.query;
		}
		
		if(this.gestor.equals("postgre")){
			this.query = "CREATE TABLE " + this.puesto 
			        +"(codigo_" + this.puesto + " integer NOT NULL,"
                    +"nombre_" + this.puesto + "  character varying(45) NOT NULL,"
			        +"apellido_" + this.puesto + " character varying(45) NOT NULL," 
			        +"nomina_" + this.puesto + " real NOT NULL,"
                    +"PRIMARY KEY( codigo_" + this.puesto +")" + ")";
			return this.query;
		}
		return null;
	}
	
	private void crearRegistros() {
	   this.conexion = null;
	    PreparedStatement ps = null;
	     this.query = "INSERT INTO "+ this.puesto +" VALUES(?,?,?,?)";
	     try {
			Class.forName(this.fichero_csv.getDriver());
		    this.conexion = DriverManager.getConnection(this.fichero_properties.getBdd(),this.fichero_properties.getUsuario(),this.fichero_properties.getPassword());
		    ps = this.conexion.prepareStatement(this.query);
		      if(this.puesto.equals("empleado")){	
		       ArrayList<Empleado> lista_empleado = this.fichero_xml.getLista_empleado();  
		        for (Empleado empleado : lista_empleado) {
					ps.setInt(1, empleado.getCodigo_empleado());
					ps.setString(2, empleado.getNombre_empleado());
					ps.setString(3, empleado.getApellido_empleado());
					ps.setDouble(4, empleado.getNomina_empleado());
					ps.executeUpdate();
				}
		      }
		      if(this.puesto.equals("jefe")){
		       ArrayList<Jefe> lista_jefe = this.fichero_xml.getLista_jefe();
		    	for (Jefe jefe : lista_jefe) {
					ps.setInt(1, jefe.getCodigo_jefe());
					ps.setString(2, jefe.getNombre_jefe());
					ps.setString(3, jefe.getApellido_jefe());
					ps.setDouble(4, jefe.getNomina_jefe());
					ps.executeUpdate();
				}
		      }	
		    ps.close();
			this.conexion.close();
	     } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	 
	}
	
	public void crearTablasHibernate(){
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();		
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
        Session session = sf.openSession();
        session.getTransaction().begin(); 
           ArrayList<Jefe> lista_jefe = this.fichero_xml.getLista_jefe();
	    	for (Jefe jefe : lista_jefe) {
	    		session.save(jefe);
            }
	        ArrayList<Empleado> lista_empleado = this.fichero_xml.getLista_empleado();
		    for (Empleado empleado : lista_empleado) {
				session.save(empleado);
			}
		session.getTransaction().commit();	
		session.close();  
		sf.close();
		System.out.println("\n[Tablas creadas con hibernate]");
     }
	
}
