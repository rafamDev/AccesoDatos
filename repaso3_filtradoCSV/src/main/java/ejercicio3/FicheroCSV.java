package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


public class FicheroCSV {

	private Empleado empleado;
	private Path ruta;
	private BufferedReader br;
	private Stream<String>lineas;
	private ArrayList<Empleado> lista_empleado;
	
	public FicheroCSV(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public void getEmpleados_dep_10() {
		try {
		    this.ruta = Paths.get("D:\\pruebas\\practica\\empleados.csv");
			this.br = Files.newBufferedReader(this.ruta);
			this.lineas = this.br.lines();
			this.lista_empleado = new ArrayList<Empleado>();
			this.lineas.forEach(cada_linea ->{
				String parametro[] = cada_linea.split(","); 
				if(parametro[5].equals(""+10)) {
			        this.empleado = new Empleado();
			        this.empleado.setCodigo(Integer.parseInt(parametro[0]));
			        this.empleado.setNombre(parametro[1]);
			        this.empleado.setApellido(parametro[2]);
			        this.empleado.setCargo(parametro[3]);
			        this.empleado.setNomina(Double.parseDouble(parametro[4]));
			        this.empleado.setDepartamento(Integer.parseInt(parametro[5]));
			        this.lista_empleado.add(this.empleado);
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void mostrarEmpleados_dep_10() {
		this.lista_empleado.forEach(System.out::println);
	}
	
}
