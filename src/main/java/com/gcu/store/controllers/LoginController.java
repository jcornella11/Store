package com.gcu.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/")
    public String display(Model model)
    {
        //Display Login Form
        model.addAttribute("title", "Login Form");

        return "login";
    }

}
