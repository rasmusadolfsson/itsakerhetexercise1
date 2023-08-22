package com.example.itsakerhetexercise1.repositories;

import com.example.itsakerhetexercise1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByAuthority(String authority);
}
