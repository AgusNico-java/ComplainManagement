package com.Complain.Management.repositories;

import com.Complain.Management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    public User findByEmail(String email);
}
