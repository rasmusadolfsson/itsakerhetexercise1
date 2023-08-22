package com.example.itsakerhetexercise1.controllers;

import com.example.itsakerhetexercise1.models.User;
import com.example.itsakerhetexercise1.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final UserRepo userRepository;

    public AdminController(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Hämta alla användare från databasen
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin"; // Thymeleaf template name without the ".html" extension
    }
}