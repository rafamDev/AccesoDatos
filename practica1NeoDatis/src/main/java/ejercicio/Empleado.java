package ejercicio;

public class Empleado {

	private int codigo;
	private String nombre;
	private int edad;
	private String puesto;
	
	public Empleado(int codigo, String nombre, int edad, String puesto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
		this.puesto = puesto;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getPuesto() {
		return puesto;
	}
	
	
}
