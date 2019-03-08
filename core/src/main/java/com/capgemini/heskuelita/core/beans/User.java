
package com.capgemini.heskuelita.core.beans;


import java.time.LocalDate;
import lombok.*;


@Data
@NoArgsConstructor
public class User {

    private String userName;

    private String password;

    private String email;

    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthdate;
    private String phone;
    private String address;
    private String gender;

}