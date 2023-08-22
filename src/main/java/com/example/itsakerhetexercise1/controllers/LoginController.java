package com.example.itsakerhetexercise1.controllers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final JdbcTemplate jdbcTemplate;

    public LoginController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf template name without the ".html" extension
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Check if the username and password combination is valid
        if (isValidLogin(username, password)) {
            return "redirect:/loggedin";
        } else {
            return "redirect:/login?error";
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Check if the username is "admin" with password "admin"
        if ("admin".equals(username) && "admin".equals(password)) {
            return true;
        }

        // Check if the username and password combination exists in the database
        String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("username")).size() == 1;

    }
}

