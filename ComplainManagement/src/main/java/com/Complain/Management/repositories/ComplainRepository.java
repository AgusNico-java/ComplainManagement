package com.Complain.Management.repositories;

import com.Complain.Management.entities.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends JpaRepository<Complain, String> {
    
}
