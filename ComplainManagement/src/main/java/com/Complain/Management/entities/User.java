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

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator (name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    
    private Long dni;
    
    @Enumerated (EnumType.STRING)
    private Role role;
    
    private Boolean active;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
