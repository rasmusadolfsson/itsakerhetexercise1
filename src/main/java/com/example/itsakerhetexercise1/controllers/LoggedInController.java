package com.example.itsakerhetexercise1.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoggedInController {

    @GetMapping("/loggedIn")
    public String loggedInPage(@RequestParam(name  = "username" ) String username, Model model) {
        model.addAttribute("fetchedName", username);
        return "loggedIn"; // Thymeleaf template name without the ".html" extension
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
