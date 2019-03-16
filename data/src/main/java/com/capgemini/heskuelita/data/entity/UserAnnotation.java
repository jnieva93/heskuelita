package com.capgemini.heskuelita.data.entity;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "users")
public class UserAnnotation {
	
	@Id
	@Column(name = "us_username", length = 30)
	private String userName;
	
	@Column(name = "us_pw", length = 30)
	private String password;
	
	@Column(name = "us_email", length = 128)
	private String email;
	
	
	public UserAnnotation() {
		super();
	}
	
	public UserAnnotation(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
