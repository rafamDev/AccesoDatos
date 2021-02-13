package controlador;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Fichero_properties {

	private String gestor;
	private String bdd;
	private String usuario;
	private String password;
	
	public Fichero_properties(String gestor){
		this.gestor = gestor;
		this.leerFichero();
	}
	
	private void leerFichero(){
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileReader("D:\\pruebas\\mapeo_JDBC_hibernate\\sql.properties"));
			this.bdd = propiedades.getProperty("bdd_" + this.gestor);
		    this.usuario = propiedades.getProperty("usuario_" + this.gestor);
			this.password = propiedades.getProperty("password_" + this.gestor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getGestor() {
		return gestor;
	}

	public String getBdd() {
		return bdd;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
}
