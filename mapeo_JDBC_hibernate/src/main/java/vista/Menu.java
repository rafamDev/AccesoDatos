package vista;

import java.util.Scanner;

import controlador.Seleccion;

public class Menu {

    public static void setMenu() {
      Scanner entrada = new Scanner(System.in);
	    while(true) {	
		 System.out.println("\nESTABLECER CONEXION:");
		 System.out.println("1-Mysql\n2-Postgresql\n0-Salir\n");
		  switch(entrada.nextInt()) {
				 case 1: Seleccion.setMysql();break;
				 case 2: Seleccion.setPostgresql();; break;
				 case 0: System.out.println("[PROGRAMA FINALIZADO]"); System.exit(0); break;
				 default: System.out.println("[Introduzca 1, 2 o 0]"); break;
				}
		 }		  
	}

}
