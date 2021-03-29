package ejercicio;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Main {
 
	public static void main(String args[]){
		Empleado e1 = new Empleado(1,"Rafa", 18, "jefe");
		Empleado e2 = new Empleado(2,"Pepe", 28, "Director");
		ODB bdoo = ODBFactory.open("D:\\PRUEBAS\\bdoo.neodatis");
		bdoo.store(e1);
		bdoo.store(e2);
		bdoo.commit();
		bdoo.close();
	}

}
