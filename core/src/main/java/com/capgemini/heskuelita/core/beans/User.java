package com.capgemini.heskuelita.core.beans;

import java.time.LocalDate;
import lombok.*;

/*La anotacion @Data detecta Getter, Setter, Constructor con todos los argumentos,
  Hashcode, Equals y toString
 */
@Data
@NoArgsConstructor
public class User {

    private String userName;
    private String password;
    private String email;
    private LocalDate created;
    private LocalDate updated;

}
