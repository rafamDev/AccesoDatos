package ejercicio2;


public class Departamento {
	
    private int codigo;
	
	private String nombre;
	
	private String localidad;
	
	
	public Departamento(){}

	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

}
