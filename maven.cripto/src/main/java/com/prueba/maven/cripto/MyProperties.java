package com.prueba.maven.cripto;

public class MyProperties {
	
	private String location = "jdbc:mysql://localhost:3306/cryptexample?useSSL=false&serverTimezone=Europe/Madrid";
	private String user = "root";
	private String pass = "abc123";
	
	
	public MyProperties() {}
	
	
	public String getLocation() {
		return location;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	
	

}
