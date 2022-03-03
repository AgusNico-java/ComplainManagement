package com.Complain.Management.exceptions;

/**
 * Creamos esta clase para diferenciar los errores de lógica del negocio de mi 
 * aplicación de los errores por defecto que podrían darse en Java.
 * @author Nico
 */
public class ComplainException extends Exception{

    public ComplainException(String message) {
        super(message);
    }
    
}
