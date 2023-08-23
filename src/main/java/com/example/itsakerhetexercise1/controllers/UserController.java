package com.example.itsakerhetexercise1.controllers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestParam String username, @RequestParam String password) {
        if (username == null || password == null) {
            return "invalid input!";
        }

        String sql = "INSERT INTO user (username, password) VALUES ('" + username + "', '" + password + "')";
        jdbcTemplate.update(sql);

        return "addUser";
    }

    @GetMapping("/addUser")
    public String addUserPage(Model model) {
        return "addUser";
    }
}