package com.Complain.Management.repositories;

import com.Complain.Management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    
    @Query("SELECT u FROM User u WHERE u.email LIKE %:email%")
    public User findByEmail(@Param("email") String email);
}
