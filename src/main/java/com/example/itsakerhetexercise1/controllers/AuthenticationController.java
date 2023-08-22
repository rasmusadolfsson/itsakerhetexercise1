package com.example.itsakerhetexercise1.controllers;

import com.example.itsakerhetexercise1.models.RegistrationDTO;
import com.example.itsakerhetexercise1.models.User;
import com.example.itsakerhetexercise1.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

}
