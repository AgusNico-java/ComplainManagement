package com.Complain.Management.entities;

import com.Complain.Management.enums.Role;
import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    /**
     * No es recomendable utilizar la clase User ya que interfiere con las cuestiones de seguridad
     * del paquete import org.springframework.security.core.userdetails.User;
     */
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    
    private Long dni;
    
    @Enumerated (EnumType.STRING)
    private Role role;
    
    private Boolean active;
}
