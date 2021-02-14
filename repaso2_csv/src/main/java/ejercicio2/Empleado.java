package ejercicio2;


public class Empleado {

	private int codigo;
	
	private String nombre;
	
	private String apellido;
	
	private double nomina;
	
	private int departamento;
	
	
	public Empleado(){}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setNomina(double nomina) {
		this.nomina = nomina;
	}


	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public double getNomina() {
		return nomina;
	}


	public int getDepartamento() {
		return departamento;
	}
	
}