package ejercicio;

import java.util.Scanner;

public class Menu {

	public static void loadMenu(){
	 Scanner entrada = new Scanner(System.in);
     Modelo modelo = new Modelo(new FicheroCSV());
	   while(true) {	
		 System.out.println("\nSELECCIONE OPCION:");
		 System.out.println("\n1-Insertar Registros. \n2-Visualizar todos los departamentos y empleados. "
		 		+ "\n3-Visualizar:\n Nombres de los empleados que trabajan en el departamento 10.\n"
		 		+ " Numero de empleados del departamento de Ventas.\n"
		 		+ " Por cada departamento, el número de empleados.\n"
		 		+ " \n4-Salir\n");
		  switch(entrada.nextInt()) {
			  case 1: modelo.opcion1();;break;
			  case 2: modelo.opcion2();;break;
			  case 3: modelo.opcion3();;break;
			  case 4: System.out.println("[PROGRAMA FINALIZADO]"); System.exit(0); break;
			  default: System.out.println("[Introduzca 1, 2, 3 o 4]"); break;
			 }
		 }
	}

}
