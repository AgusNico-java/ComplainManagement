package com.Complain.Management.controllers;

import com.Complain.Management.entities.SupplierComplain;
import com.Complain.Management.services.SupComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/supcomplain")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class SupplierComplainController {
    
    private SupComplainService supService;
    
    @Autowired
    public SupplierComplainController(SupComplainService supService){
        this.supService = supService;
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String supComplainForm(ModelMap model){
        model.addAttribute("supComplain", new SupplierComplain());
        return "supplierComplain/suppliercomplain-form";
    }
    
    @RequestMapping (value = "/form", method = RequestMethod.POST)
    public String supComplainForm(@ModelAttribute SupplierComplain supComplain){
        supService.saveComplain(supComplain);
        return "redirect:/supComplain/list";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String supComplainList(ModelMap model){
        
        return "supplierComplain/suppliercomplain-list";
    }
}
