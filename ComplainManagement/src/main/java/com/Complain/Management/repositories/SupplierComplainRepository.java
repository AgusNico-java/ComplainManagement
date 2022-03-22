package com.Complain.Management.repositories;

import com.Complain.Management.entities.SupplierComplain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierComplainRepository extends JpaRepository<SupplierComplain, String> {
    
}
