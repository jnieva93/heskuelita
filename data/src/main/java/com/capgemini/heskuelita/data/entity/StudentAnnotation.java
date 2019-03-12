package com.capgemini.heskuelita.data.entity;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
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

	public StudentAnnotation(String firstName, String lastName, String dni, String phone, String address,
			String gender) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
	}
	
	

}
