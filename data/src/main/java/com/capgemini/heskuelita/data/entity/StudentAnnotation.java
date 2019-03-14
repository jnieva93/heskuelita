package com.capgemini.heskuelita.data.entity;

import javax.persistence.*;
import lombok.*;

@Entity(name = "Student")
@Table(name = "student")
public class StudentAnnotation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "student_seq")
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@Column(name = "dni", length = 20)
	private String dni;
	
	@Column(name = "phone", length = 50)
	private String phone;
	
	@Column(name = "address", length = 50)
	private String address;
	
	@Column(name = "gender", length = 20)
	private String gender;
	
	@Column(name = "username", length = 30)
	private String userName;
	
	
	public StudentAnnotation() {
		super();
	}

	public StudentAnnotation(String firstName, String lastName, String dni, String phone, String address,
			String gender, String userName) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.userName = userName;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
