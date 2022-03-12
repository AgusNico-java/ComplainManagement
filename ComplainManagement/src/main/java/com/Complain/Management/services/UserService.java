package com.Complain.Management.services;

import com.Complain.Management.entities.User;
import com.Complain.Management.exceptions.UserException;
import com.Complain.Management.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements UserDetailsService{
    private UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    /**
     * Se encarga de validar que se ingresen los datos necesarios de forma correcta
     * al crear a un usuario.
     * @param user
     * @throws com.Complain.Management.exceptions.UserException
     */
    public void validateUser (User user) throws UserException{
        if (user.getName().trim().equals("") || user.getName() == null){
            throw new UserException("Debe ingresar un nombre");
        }
        if (user.getPassword().trim().equals("") || user.getPassword() == null){
            throw new UserException("Debe guardar una clave");
        }
        String dni = (String) user.getDni().toString();
        if (dni == null){
            throw new UserException("Debe ingresar un número de DNI");
        }
        if (dni.length()<8 || dni.length()>8){
            throw new UserException("El DNI ingresado es incorrecto");
        }
    }
    
    /**
     * Guarda un nuevo usuario en la base de datos
     * @param user
     */
    @Transactional(rollbackOn = {Exception.class})
    public void saveUser (User user){
        try {
            validateUser(user);
            //crear un método de activate if new
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        } catch (UserException e) {
            e.getMessage();
        }
        userRepository.save(user);
    }
    
    /**
     * Genera una lista con todos los usuarios registrados en la base de datos.
     * @return
     */
    @Transactional
    public List<User> userList(){
        return userRepository.findAll();
    }
    
    /**
     * Devuelve un único usuario de la lista, generado por el ID
     * @param id
     * @return
     */
    @Transactional
    public User oneUser(String id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepository.findByMail(email);
        if (user == null) {
            return null;
        }
        List <GrantedAuthority> permissions = new ArrayList<>();
        GrantedAuthority rolePermissions = new SimpleGrantedAuthority ("ROLE_" + user.getRole().toString());
        permissions.add(rolePermissions);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), permissions);
    }
    
}
