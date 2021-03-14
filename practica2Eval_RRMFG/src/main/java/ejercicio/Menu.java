package ejercicio;

import java.util.Scanner;

public class Menu {

	public static void loadMenu(){
	 Scanner entrada = new Scanner(System.in);
     Modelo modelo = new Modelo(new FicheroCSV());
	   while(true) {	
		 System.out.println("\nSELECCIONE OPCION:");
		 System.out.println("\n1-Opcion 1\n2-Opcion 2 \n3-opcion 3 \n4-Salir\n");
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
