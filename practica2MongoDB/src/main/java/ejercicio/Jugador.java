package ejercicio;

public class Jugador {

	private int codigo;
	private String nombre;
	private int edad;
	private int codigoEquipo;
	
	public Jugador(int codigo, String nombre, int edad, int codigoEquipo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
		this.codigoEquipo = codigoEquipo;
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
	public int getCodigoEquipo() {
		return codigoEquipo;
	}
	
}
