package com.Complain.Management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador encargado de la página de inicio.
 * @author Nico
 */        
@Controller
@RequestMapping("")
public class HomeController {
    
    @RequestMapping (method = RequestMethod.GET)
    public String homePage (){
        return "index.html";
    }
}
