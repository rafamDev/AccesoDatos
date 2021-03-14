package ejercicio;

import java.math.BigInteger;

import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Modelo {

  private FicheroCSV ficheroCSV;
  private ODB bdd;
  private IQuery query;
  private Objects<Departamento> departamentos;
  private Objects<Empleado> empleados;
  
	public Modelo(FicheroCSV ficheroCSV){
		this.ficheroCSV = ficheroCSV;
	}

  public void opcion1(){
	this.bdd = ODBFactory.open("D:\\PRUEBAS\\bdd.neodatis");
	ArrayList<Departamento> lista_departamento = this.ficheroCSV.getLista_departamento();
	  for (Departamento departamento : lista_departamento) {
		 this.bdd.store(departamento);
	  }
	ArrayList<Empleado> lista_empleado = this.ficheroCSV.getLista_empleado();
	  for (Empleado empleado : lista_empleado) {
		 this.bdd.store(empleado);
	  }  
    this.bdd.commit();
    this.bdd.close();
  }

  public void opcion2(){
	 this.bdd = ODBFactory.open("D:\\PRUEBAS\\bdd.neodatis");   
     this.mostrarDepartamentos();
     this.mostrarEmpleados();
	 this.bdd.close();
  }
 
  private void mostrarDepartamentos(){
	this.query = new CriteriaQuery(Departamento.class);
	this.departamentos = this.bdd.getObjects(this.query);
	  for(Departamento departamento : this.departamentos){
		 System.out.print("Codigo departamento:" + departamento.getCodigoD() + " ");
		 System.out.print("Nombre departamento:" + departamento.getNombreD() + " ");
		 System.out.println("Localidaad departamento: " + departamento.getLocalidad() + " ");
	  }
  }
  
  private void mostrarEmpleados(){
	this.query = new CriteriaQuery(Empleado.class);
    this.empleados = this.bdd.getObjects(query);
	System.out.println("");
	  for(Empleado empleado : empleados){
		query = new CriteriaQuery(Departamento.class,Where.equal("codigoD", empleado.getDepartamento()));
		    this.departamentos = this.bdd.getObjects(query);
			  System.out.print("Codigo empleado: " + empleado.getCodigoE() + " ");
			  System.out.print("Nombre empleado: " + empleado.getNombreE() + " ");
			  System.out.print("Apellido empleado: " + empleado.getApellidos() + " ");
			  System.out.println("Depatamento empleado: " + this.departamentos.getFirst().getNombreD() + " ");
		}
  }
  
  public void opcion3(){
	this.bdd = ODBFactory.open("D:\\PRUEBAS\\bdd.neodatis");  
	this.empleadosDep10();
	this.nEmpleadosDepVentas();
	this.nEmpleadosXdep();
    this.bdd.close();
  }

  private void empleadosDep10(){
	this.query = new CriteriaQuery(Empleado.class,Where.equal("departamento",10));
	this.empleados = this.bdd.getObjects(this.query);
	  for (Empleado empleado : this.empleados) {
		   System.out.println("Nombres de los empleados que pertenecen al departamento con codigo 10: " + empleado.getNombreE() + " ");
	  }
  }
  
  private void nEmpleadosDepVentas(){
	 CriteriaQuery cQuery = new CriteriaQuery(Empleado.class, Where.equal("departamento",10));
	 Values valores = this.bdd.getValues(new ValuesCriteriaQuery(cQuery).count("nombreE"));
	 ObjectValues objetosValores = valores.nextValues();
	 BigInteger numero = (BigInteger)objetosValores.getByAlias("nombreE");
	 System.out.println("Número empleados en Ventas: " + numero);
  }

  private void nEmpleadosXdep(){
	this.departamentos = this.bdd.getObjects(new CriteriaQuery(Departamento.class));
	Values valores = this.bdd.getValues(new ValuesCriteriaQuery(Empleado.class).count("nombreE").groupBy("departamento"));	
	 ObjectValues valoresObj = null;	
		  for(Departamento departamento : this.departamentos) {
				valoresObj = valores.next();
				System.out.println("Departamento " +  departamento.getNombreD() + ": " + valoresObj.getByIndex(0) + " ");
		  }  
  }


}
