package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FicheroCSV {

   private FicheroXML ficheroXML;
   private File csv;
   private BufferedWriter br;
   
   public FicheroCSV(FicheroXML ficheroXML) {
	   this.ficheroXML = ficheroXML;
   }

   public void crearDepartamentos() {
	 try {
		this.csv = new File("D:\\pruebas\\repaso\\csv_departamentos.csv");
		this.csv.createNewFile();
		this.br = new BufferedWriter(new FileWriter("D:\\pruebas\\repaso\\csv_departamentos.csv"));
		 this.br.write("--Departamentos--\n");
		 ArrayList<Departamento> lista_departamento = this.ficheroXML.getLista_departamento();
		  for (Departamento departamento : lista_departamento) {
			this.br.write(departamento.getCodigo() + "," + departamento.getNombre() + "," + departamento.getLocalidad() + "\n");
	      }
		  this.br.flush();
		  this.br.close();
	 } catch (IOException e) {
	   e.printStackTrace();
	 }
	   
   }
   
   public void crearEmpleados() {
	  try {
	    this.csv = new File("D:\\pruebas\\repaso\\csv_empleados.csv");
		this.csv.createNewFile();
		this.br = new BufferedWriter(new FileWriter("D:\\pruebas\\repaso\\csv_empleados.csv"));
		 this.br.write("--Empleados--\n");
		 ArrayList<Empleado> lista_empleados = this.ficheroXML.getLista_empleado();
		  for (Empleado empleado : lista_empleados) {
			this.br.write(empleado.getCodigo() + "," + empleado.getNombre() + "," + empleado.getApellido() + "," + empleado.getNomina() + "," + empleado.getDepartamento() + "\n");
	      }
		  this.br.flush();
		  this.br.close();
	 } catch (IOException e) {
	   e.printStackTrace();
	 }
   } 

}
