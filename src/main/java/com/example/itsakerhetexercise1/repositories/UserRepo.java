package com.example.itsakerhetexercise1.repositories;

import com.example.itsakerhetexercise1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    List<User> findByUsername(String userUsername);
}
