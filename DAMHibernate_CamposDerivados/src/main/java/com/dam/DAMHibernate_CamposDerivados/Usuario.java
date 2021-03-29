package com.dam.DAMHibernate_CamposDerivados;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Usuario {

   	@Id
	private String login;
	
	@ColumnTransformer(
	 write=" MD5(?) "
	)
	private String passsword;
	
	@CreationTimestamp
	private Timestamp fecha_alta;

	@Generated(GenerationTime.INSERT)
	@Column(columnDefinition = " VARCHAR(30)  AS (CONCAT(login,' ',fecha_alta)) ")
	private String id;

	public Usuario(String login, String passsword) {
		super();
        this.login = login;
		this.passsword = passsword;
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPasssword() {
		return passsword;
	}


	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}


}
