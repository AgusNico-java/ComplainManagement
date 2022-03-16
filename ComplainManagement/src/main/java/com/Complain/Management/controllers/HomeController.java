package com.Complain.Management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador encargado de la página de inicio.
 * @author Nico
 */        
@Controller
@RequestMapping("/home")
public class HomeController {
    
    @RequestMapping (value=".../", method = RequestMethod.GET)
    public String home (){
        return "redirect: /home";
    }
    
    @RequestMapping (method = RequestMethod.GET)
    public String homePage (){
        return "index.html";
    }
}
