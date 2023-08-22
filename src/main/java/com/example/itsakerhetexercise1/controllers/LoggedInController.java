package com.example.itsakerhetexercise1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoggedInController {

    @GetMapping("/loggedin")
    public String loggedInPage() {
        return "loggedin"; // Thymeleaf template name without the ".html" extension
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
