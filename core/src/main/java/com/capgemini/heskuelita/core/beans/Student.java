package com.capgemini.heskuelita.core.beans;

import java.time.LocalDate;

import lombok.*;

// Cumple la misma funcion que user
@Data
@NoArgsConstructor
public class Student {

    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthdate;		// Aun no implementado
    private String phone;
    private String address;
    private String gender;
    private String userName;
	
}
