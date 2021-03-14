package ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FicheroCSV {

	private Path ruta;
	private BufferedReader br;
	private Stream<String>lineas;
	private ArrayList<Departamento> lista_departamento;
	private ArrayList<Empleado> lista_empleado;
	
	public FicheroCSV(){
		this.leerDepartamentos();
		this.leerEmpleados();
	}

	private void leerDepartamentos() {
		try {
			this.lista_departamento = new ArrayList<Departamento>();
			this.ruta = Paths.get("D:\\pruebas\\departamentos.csv");
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lineas.forEach(cada_linea ->{
				String parametro[] = cada_linea.split(","); 
				this.lista_departamento.add(new Departamento(Integer.parseInt(parametro[0]), parametro[1], parametro[2]));
			});
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	private void leerEmpleados() {
		try {
			this.lista_empleado = new ArrayList<Empleado>();
			this.ruta = Paths.get("D:\\pruebas\\empleados.csv");
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lineas.forEach(cada_linea ->{
				String parametro[] = cada_linea.split(","); 
				this.lista_empleado.add(new Empleado(Integer.parseInt(parametro[0]),
				       parametro[1], parametro[2],parametro[3],
				       Float.parseFloat(parametro[4]),Integer.parseInt(parametro[5])));
			});
		} catch (IOException e) {
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
