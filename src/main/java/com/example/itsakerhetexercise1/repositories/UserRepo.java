package com.example.itsakerhetexercise1.repositories;

import com.example.itsakerhetexercise1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
