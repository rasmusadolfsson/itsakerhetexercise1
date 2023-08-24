package com.example.itsakerhetexercise1.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @GetMapping("/")
    public String helloUserController(){
        return "User access level";
    }

}
