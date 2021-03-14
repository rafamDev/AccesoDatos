package ejercicio;

public class Empleado {
  
  private int codigoE;
  private String nombreE;
  private String apellidos;
  private String puesto;
  private float salario;
  private int departamento;

  public Empleado(int codigoE, String nombreE, String apellidos, String puesto, float salario, int departamento) {
	super();
	this.codigoE = codigoE;
	this.nombreE = nombreE;
	this.apellidos = apellidos;
	this.puesto = puesto;
	this.salario = salario;
	this.departamento = departamento;
  }

  public int getCodigoE() {
	return codigoE;
  }

  public String getNombreE() {
	return nombreE;
  }

  public String getApellidos() {
	return apellidos;
  }

  public String getPuesto() {
	return puesto;
  }

  public float getSalario() {
	return salario;
  }

  public int getDepartamento() {
	return departamento;
  }


}
