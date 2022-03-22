package com.Complain.Management.services;

import com.Complain.Management.entities.SupplierComplain;
import com.Complain.Management.repositories.SupplierComplainRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupComplainService {
    
    private SupplierComplainRepository supRepository;
    
    @Autowired
    public SupComplainService (SupplierComplainRepository supRepository){
        this.supRepository = supRepository;
    }
    
    private String complainCodeGenerator(){
        
        String codeString = "RE-PV-" + ((int) supRepository.count()+1);
        return codeString;
    }
    
    @Transactional (value = Transactional.TxType.REQUIRED, rollbackOn = {Exception.class})
    public void saveComplain (SupplierComplain supComplain){
        if (supComplain.getSolved() == null){
            supComplain.setSolved(Boolean.FALSE);
        }
        if (supComplain.getComplainCode()==null){
            supComplain.setComplainCode(complainCodeGenerator());
        }
        supRepository.save(supComplain);
    }
    
    
    
}
