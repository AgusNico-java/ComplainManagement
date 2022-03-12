
package com.Complain.Management.services;

import com.Complain.Management.entities.Complain;
import com.Complain.Management.exceptions.ComplainException;
import com.Complain.Management.repositories.ComplainRepository;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainService {
    
    private ComplainRepository useCRepository;
    
    @Autowired
    public ComplainService(ComplainRepository useCRepository) {
        this.useCRepository = useCRepository;
    }
    
    /**
     * Guarda un reclamo en la base de datos
     * @param complain 
     */
    @Transactional(rollbackOn = {Exception.class})
    public void saveComplain (Complain complain){
        try {
            validateComplain(complain);
        } catch (ComplainException e) {
            e.getMessage();
        }
        if (complain.getComplainCode() == null || complain.getComplainCode().trim().equals("")) {
            String code = calculateComplainCode();
            complain.setComplainCode(code);
            complain.setSolved(Boolean.FALSE);
        }
        useCRepository.save(complain);
    }
    
    /**
     * Se encarga de generar una lista de reclamos a mostrarse en el navegador
     * @return 
     */
    @Transactional
    public List<Complain> complainList(){
        return useCRepository.findAll();
    }
    /**
     * Se encarga de mostrar un único reclamo.
     * @param id
     * @return 
     */
    @Transactional
    public Complain oneComplain(String id){
        return useCRepository.findById(id).orElse(null);
    }
    
    /**
     * Se encarga de validar que se ingresen los datos que son obligatorios para
     * efectuar un reclamo.Sin estos datos, el reclamo no se hará efectivo. Estos serán, de momento, nombre del consumidor, nombre del producto y
     * defecto encontrado. Ningún reclamo puede guardarse sin alguno de estos datos.
     * @param complain
     * @throws com.Complain.Management.exceptions.ComplainException 
     */
    public void validateComplain(Complain complain)throws ComplainException{
        if (complain.getConsumerName().trim().equals("") || complain.getConsumerName() == null){
            throw new ComplainException("Debe agregarse un nombre");
        }
        if (complain.getProductName().trim().equals("") || complain.getProductName() == null) {
            throw new ComplainException("Debe indicar con qué producto tuvo el problema");
        }
    }
    
    /**
     * Realiza el calculo mediante el cual se obtiene el código de reclamo
     * que será guardado en la entidad
     * @return 
     */
    public String calculateComplainCode (){
        
        String codeString = "RE-" + LocalDate.now().getYear() + "-";
        int codeNumber = (int) useCRepository.count() + 1;
        String complainCode = codeString + codeNumber;
        
        return complainCode;
    }
}
