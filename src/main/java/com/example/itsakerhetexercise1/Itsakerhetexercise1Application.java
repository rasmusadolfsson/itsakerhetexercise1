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
            Role userRole = roleRepo.save(new Role("USER"));

            Set<Role> adminroles = new HashSet<>();
            adminroles.add(adminRole);
            Set<Role> userroles = new HashSet<>();
            userroles.add(userRole);

            User admin = new User(1L, "admin", passwordEncoder.encode("adminpassword"), adminroles);
            User user1 = new User(2L, "user1", passwordEncoder.encode("user1password"), userroles);
            User user2 = new User(3L, "user2", passwordEncoder.encode("user2password"), userroles);
            User user3 = new User(4L, "user3", passwordEncoder.encode("user3password"), userroles);
            User user4 = new User(5L, "user4", passwordEncoder.encode("user4password"), userroles);

            userRepo.save(admin);
            userRepo.save(user1);
            userRepo.save(user2);
            userRepo.save(user3);
            userRepo.save(user4);
        };
    }
}
