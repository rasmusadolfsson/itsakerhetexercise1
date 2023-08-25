package com.example.itsakerhetexercise1.controllers;

import com.example.itsakerhetexercise1.models.RegistrationDTO;
import com.example.itsakerhetexercise1.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegistrationDTO body){
        authenticationService.registerUser(body.getUsername(), body.getPassword());
        return "redirect:/register";
    }
}
