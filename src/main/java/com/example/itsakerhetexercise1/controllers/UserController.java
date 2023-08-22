package com.example.itsakerhetexercise1.controllers;

import com.example.itsakerhetexercise1.models.User;
import com.example.itsakerhetexercise1.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {

    private final UserRepo userRepo;

    UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestBody User user){
        List<User> listOfUsers = userRepo.findByUsername(user.getUsername());
        if(user.getUsername() == null || listOfUsers.size() > 0){
            return "invalid name!";
        }

        if(user.getPassword() == null){
            return "invalid password!";
        }

        userRepo.save(user);
        return "added user";
    }

    @GetMapping("/addUser")
    public String addUserPage(Model model) {
        return "addUser";
    }
}