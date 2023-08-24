package com.example.itsakerhetexercise1.controllers;

import com.example.itsakerhetexercise1.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoggedInController {

    @GetMapping("/loggedin")
    public String loggedInPage(@AuthenticationPrincipal User user, Model model) {
        boolean isAdmin = false;

        if (user.getAuthorities().stream()
                .anyMatch(authority -> "ADMIN".equals(authority.getAuthority()))) {
            isAdmin = true;
        }

        model.addAttribute("isAdmin", isAdmin);
        return "loggedin"; // Thymeleaf template name without the ".html" extension
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}
