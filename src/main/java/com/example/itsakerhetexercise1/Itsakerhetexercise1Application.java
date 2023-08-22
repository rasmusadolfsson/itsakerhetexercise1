package com.example.itsakerhetexercise1;

import com.example.itsakerhetexercise1.models.Role;
import com.example.itsakerhetexercise1.models.User;
import com.example.itsakerhetexercise1.repositories.RoleRepo;
import com.example.itsakerhetexercise1.repositories.UserRepo;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Itsakerhetexercise1Application {

    public static void main(String[] args) {
        SpringApplication.run(Itsakerhetexercise1Application.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            if (roleRepo.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = roleRepo.save(new Role("ADMIN"));
            roleRepo.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            User admin = new User(1L, "admin", passwordEncoder.encode("AdminPassword"), roles);

            userRepo.save(admin);
        };
    }
}
