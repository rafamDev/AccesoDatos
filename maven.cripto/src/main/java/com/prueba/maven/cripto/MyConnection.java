package com.prueba.maven.cripto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyConnection {

	private MyCrypAES cryp;
	private boolean exist;

	public MyConnection() {}
	
	 public void setConexion(boolean exist){
		this.exist = exist;
		this.cryp = new MyCrypAES();
        Connection conexion = null;
		
       if(this.exist == true){ 
        try{
			String location = this.cryp.desencriptar(this.cryp.getLocation(), "secret1");
			String user = this.cryp.desencriptar(this.cryp.getUser(), "secret2");
			String password = this.cryp.desencriptar(this.cryp.getPassword(), "secret3");

		    Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(location,user,password);
		   
			System.out.println("CONEXION ESTABLECIDA\n");
			
     		MyXml xml = new MyXml();
			
     	    MyReadXML read = new MyReadXML(xml);
			
			conexion.close();
			
		}catch(Exception ex){
		    System.out.println("NO CONECTA CON LA BASE DE DATOS");
			ex.printStackTrace();
		}
	 
  
	 } else {
		   System.out.println("CONEXION RECHAZADA POR EL PROGRAMA");
		   return;
	   }
	 }
	 	

		public boolean isExist() {
			return exist ? false : true;
		}

 }
