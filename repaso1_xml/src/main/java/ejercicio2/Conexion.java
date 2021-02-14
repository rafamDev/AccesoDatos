package ejercicio2;

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

	private ArrayList<Departamento> lista_departamento;
	private ArrayList<Empleado> lista_empleado;

    public Conexion(){
	   this.consultar();
	}

    private void consultar() {
	   Connection conexion = null;
	    Statement st = null;
	     String query="";
	       ResultSet rs = null;
	     this.lista_departamento = new ArrayList<Departamento>();
	     this.lista_empleado = new ArrayList<Empleado>();
	     try {
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/empresa","postgres","abc123");
			st = conexion.createStatement();
			query = "SELECT * FROM departamento";
		    rs = st.executeQuery(query);
			   while(rs.next()){
				  this.lista_departamento.add(new Departamento(rs.getInt("codigo"), rs.getString("nombre"),rs.getString("localidad"))); 
                }
			rs.close();
		    query = "SELECT * FROM empleado";
		    rs = st.executeQuery(query);
			   while(rs.next()){
				   this.lista_empleado.add(new Empleado( rs.getInt("codigo"), rs.getString("nombre"),rs.getString("apellido"),  rs.getString("cargo"),rs.getInt("nomina"), rs.getInt("departamento"))); 
			    }
			rs.close();
			st.close();
			conexion.close();
			
		 } catch (SQLException e) {
		     e.printStackTrace();
		 }
	   
	}

	public ArrayList<Departamento> getLista_departamento() {
		return lista_departamento;
	}

	public ArrayList<Empleado> getLista_empleado() {
		return lista_empleado;
	}

}
