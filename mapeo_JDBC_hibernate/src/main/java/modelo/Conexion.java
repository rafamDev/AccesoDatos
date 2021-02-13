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
	private Fichero_xml fichero_xml;
	private Fichero_csv fichero_csv;
	private Fichero_properties fichero_properties; 
	
	public Conexion(String gestor){
		this.gestor = gestor;
		this.fichero_xml = new Fichero_xml();
		this.fichero_csv = new Fichero_csv(gestor);
		this.fichero_properties = new Fichero_properties(gestor);
	}
	
	public void crearTablasJDBC(){
	   this.conexion = null;
	      Statement st = null;
		  try {
			Class.forName(this.fichero_csv.getDriver());
			this.conexion = DriverManager.getConnection(this.fichero_properties.getBdd(),this.fichero_properties.getUsuario(),this.fichero_properties.getPassword());
			st = this.conexion.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS jefe");
			st.executeUpdate(this.getQueryJefe());
			st.executeUpdate("DROP TABLE IF EXISTS empleado");
			st.executeUpdate(this.getQueryEmpleado());
			st.close();
			this.conexion.close();
			System.out.println("[Tablas creadas con JDBC (" + this.gestor + ")]");
			this.crearRegistros();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	 }

	private String getQueryJefe() {
		if(this.gestor.equals("mysql")){
		      this.query ="CREATE TABLE jefe"
			        +"(codigo_jefe INTEGER NOT NULL,"
                    +"nombre_jefe VARCHAR(45) NOT NULL,"
			        +"apellido_jefe VARCHAR(45) NOT NULL," 
			        +"nomina_jefe DOUBLE NOT NULL,"
                    +"PRIMARY KEY( codigo_jefe )" + ")";
			return this.query;
		}
		
		if(this.gestor.equals("postgre")){
			this.query = "CREATE TABLE jefe"
			        +"(codigo_jefe integer NOT NULL,"
                    +"nombre_jefe character varying(45) NOT NULL,"
			        +"apellido_jefe character varying(45) NOT NULL," 
			        +"nomina_jefe real NOT NULL,"
                    +"PRIMARY KEY( codigo_jefe )" + ")";
			return this.query;
		}
		return null;
	}
	
    private String getQueryEmpleado() {
    	if(this.gestor.equals("mysql")){
		      this.query ="CREATE TABLE empleado"
			        +"(codigo_empleado INTEGER NOT NULL,"
                    +"nombre_empleado VARCHAR(45) NOT NULL,"
			        +"apellido_empleado VARCHAR(45) NOT NULL," 
			        +"nomina_empleado DOUBLE NOT NULL,"
                    +"PRIMARY KEY( codigo_empleado )" + ")";
			return this.query;
		}
		
		if(this.gestor.equals("postgre")){
			this.query = "CREATE TABLE empleado"
			        +"(codigo_empleado integer NOT NULL,"
                    +"nombre_empleado character varying(45) NOT NULL,"
			        +"apellido_empleado character varying(45) NOT NULL," 
			        +"nomina_empleado real NOT NULL,"
                    +"PRIMARY KEY( codigo_empleado )" + ")";
			return this.query;
		}
		return null;
	}
	
	private void crearRegistros() {
	   this.conexion = null;
	    PreparedStatement ps = null;
	     this.query = "INSERT INTO jefe VALUES(?,?,?,?)";
	     try {
			Class.forName(this.fichero_csv.getDriver());
		    this.conexion = DriverManager.getConnection(this.fichero_properties.getBdd(),this.fichero_properties.getUsuario(),this.fichero_properties.getPassword());
		    ps = this.conexion.prepareStatement(this.query);
		     ArrayList<Empleado> lista_empleado = this.fichero_xml.getLista_empleado();  
		        for (Empleado empleado : lista_empleado) {
					ps.setInt(1, empleado.getCodigo_empleado());
					ps.setString(2, empleado.getNombre_empleado());
					ps.setString(3, empleado.getApellido_empleado());
					ps.setDouble(4, empleado.getNomina_empleado());
					ps.executeUpdate();
				}
		   this.query = "INSERT INTO empleado VALUES(?,?,?,?)";
		   ps = this.conexion.prepareStatement(this.query);
		     ArrayList<Jefe> lista_jefe = this.fichero_xml.getLista_jefe();
		    	for (Jefe jefe : lista_jefe) {
					ps.setInt(1, jefe.getCodigo_jefe());
					ps.setString(2, jefe.getNombre_jefe());
					ps.setString(3, jefe.getApellido_jefe());
					ps.setDouble(4, jefe.getNomina_jefe());
					ps.executeUpdate();
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
