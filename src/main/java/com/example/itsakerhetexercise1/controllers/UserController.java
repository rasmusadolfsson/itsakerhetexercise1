package com.example.itsakerhetexercise1.controllers;

import com.example.itsakerhetexercise1.models.User;
import com.example.itsakerhetexercise1.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserRepo userRepo;

    UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestParam String username, @RequestParam String password){
        //List<User> listOfUsers = userRepo.findByUsername(user.getUsername());
        if(username == null){
            return "invalid name!";
        }

        if(password == null){
            return "invalid password!";
        }
        User user = new User(username, password);
        userRepo.save(user);
        return "addUser";
    }

    @GetMapping("/addUser")
    public String addUserPage(Model model) {
        return "addUser";
    }
}