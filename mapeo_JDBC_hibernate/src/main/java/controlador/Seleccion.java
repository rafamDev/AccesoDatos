package controlador;

import java.util.Scanner;
import modelo.Conexion;

public class Seleccion {

	public static void setMysql(){
		Conexion conexion = new Conexion("mysql");
		subMenu(conexion);
	}
	
	private static void subMenu(Conexion conexion) {
		System.out.println("ESTABLECER: ");
		System.out.println("1-JDBC\n2-HIBERNATE\n0-Salir\n");
		    Scanner entrada = new Scanner(System.in);
			switch(entrada.nextInt()) {
			case 0: System.out.println("[PROGRAMA FINALIZADO]"); System.exit(0);
			case 1: conexion.crearTablasJDBC();break;
			case 2: conexion.crearTablasHibernate(); break;
			default: System.out.println("[Introduzca 1, 2 o 0]"); break;
		   }
	 }

	public static void setPostgresql(){
		Conexion conexion = new Conexion("postgre");
		conexion.crearTablasJDBC();
	}
	
}
