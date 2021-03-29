package com.prueba.maven.cripto;

import java.util.Scanner;

public class MyMenu {
	
	public MyMenu() {}
	
	
	public void setMenu() {
	  System.out.println("SET CONEXION?");
	  System.out.println("1-YES 0-NO\n");
		Scanner entrada = new Scanner(System.in);
		int seleccion = entrada.nextInt();
		  switch(seleccion) {
		   case 1: vista(); break;
		   case 0: vista2();
		  }
	}
 
	private void vista() {
	  MyConnection conexion = new MyConnection();
	   conexion.setConexion(true);
	}
	
    private void vista2() {
	  System.out.println("CONEXION RECHAZADA POR EL USUARIO");
	    System.exit(0);
	}
}
