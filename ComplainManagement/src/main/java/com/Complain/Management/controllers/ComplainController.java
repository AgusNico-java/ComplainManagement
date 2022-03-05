package com.Complain.Management.controllers;

import com.Complain.Management.entities.Complain;
import com.Complain.Management.services.ComplainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Controlador de prueba para dirigir a la página de inicio
@Controller
@RequestMapping("/complain")
public class ComplainController {

    private ComplainService useCService;

    @Autowired
    public ComplainController(ComplainService useCService) {
        this.useCService = useCService;
    }

    /**
     * Método que muestra el formulario
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String complainForm(ModelMap model) {
        model.addAttribute("complain", new Complain());
        return "form.html";
    }
    
    @RequestMapping(value = "/switch", method = RequestMethod.GET)
    public String switchButton(@RequestParam String id, ModelMap model){
        model.addAttribute("complain", useCService.oneComplain(id));
        return "complains/list";
    }

    /**
     * Método que carga los datos del formulario en mi DB.Calcula y setea el
     * código del reclamo.
     *
     * @param complain
     * @param model
     * @return
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitData(@ModelAttribute Complain complain) {
        useCService.saveComplain(complain);
        return "redirect:/complain/list";
    }
    
    @RequestMapping(value = "/switch", method = RequestMethod.POST)
    public String saveSwitch(@RequestParam String id){
        
        Complain complain = useCService.oneComplain(id);
        
        System.out.println(complain.getSolved());
        
        if (complain.getSolved() || complain.getSolved() == null) {
            complain.setSolved(Boolean.FALSE);
        } else {
            complain.setSolved(Boolean.TRUE);
        }
        useCService.saveComplain(complain);
        return "redirect:/complain/list";
    }

    /**
     * Método que busca y lista todos los reclamos de una tabla de base de datos
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String complainList(ModelMap model) {
        List<Complain> complains = useCService.complainList();
        model.addAttribute("complains", complains);
        return "complains/list";
    }

    /**
     * Método que cambia el valor del parámetro solved.
     *
     * @param complain
     * @return
     */
    /**
    @RequestMapping(value = "/switch", method = RequestMethod.POST)
        public String switchSolved(@ModelAttribute Complain complain) {
        
            System.out.println(complain.getId());
            
        return "redirect:/complain/list";
    }
    */
}
