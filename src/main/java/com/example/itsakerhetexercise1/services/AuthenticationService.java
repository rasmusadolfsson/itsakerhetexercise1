package com.example.itsakerhetexercise1.services;

import com.example.itsakerhetexercise1.models.Role;
import com.example.itsakerhetexercise1.models.User;
import com.example.itsakerhetexercise1.repositories.RoleRepo;
import com.example.itsakerhetexercise1.repositories.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();

        roles.add(userRole);

        System.out.println(userRole.getAuthority());

        return userRepo.save(new User(username,encodedPassword,roles));
    }
}
