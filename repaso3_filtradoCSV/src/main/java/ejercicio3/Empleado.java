package ejercicio3;

public class Empleado {

	private int codigo;
	private String nombre;
	private String apellido;
	private String cargo;
	private double nomina;
	private int departamento;
	
	public Empleado() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
    public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getNomina() {
		return nomina;
	}

	public void setNomina(double nomina) {
		this.nomina = nomina;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo
				+ ", nomina=" + nomina + ", departamento=" + departamento + "]";
	}
	
	
}
