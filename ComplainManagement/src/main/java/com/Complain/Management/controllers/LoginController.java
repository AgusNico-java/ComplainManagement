package com.Complain.Management.controllers;

import com.Complain.Management.entities.User;
import com.Complain.Management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    UserService userService;
    
    @Autowired
    public LoginController (UserService userService){
        this.userService = userService;
    }
    
    /**
     *
     * @param error
     * @param model
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public String loginForm(@RequestParam(required = false)String error, ModelMap model){
        if (error!=null) {
            model.put("Error", "El e-mail o la contraseña son inválidos");
        }
        return "users/login";
    }
    
    @RequestMapping (value="/register", method = RequestMethod.GET)
    public String signUpForm (ModelMap model){
        model.addAttribute("user", new User());
        return "/users/register";
    }
    
    @RequestMapping (value="/register", method = RequestMethod.POST)
    public String signUpForm (@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/complain/list";
    }
}
