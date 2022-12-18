package com.gcu.store.controllers;

import com.gcu.store.business.UserBusinessService;
import com.gcu.store.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    UserBusinessService service;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("title", "Register");
        model.addAttribute("userModel", new UserModel());

        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
    {
        // Check form data for errors
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Register");
            return "register";
        }

        //Encode Password
        String encoded = new BCryptPasswordEncoder().encode(userModel.getPassword());

        // Add encoded password to UserModel
        userModel.setPassword(encoded);

        // Get user service and add new user
        service.addUser(userModel);

        return "login";

    }


}
