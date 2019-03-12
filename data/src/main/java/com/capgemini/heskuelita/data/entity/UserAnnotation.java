package com.capgemini.heskuelita.data.entity;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class UserAnnotation {
	
	public UserAnnotation(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	

	@Id
	@Column(name = "us_username", length = 30)
	private String userName;
	
	@Column(name = "us_pw", length = 30)
	private String password;
	
	@Column(name = "us_email", length = 128)
	private String email;

}
