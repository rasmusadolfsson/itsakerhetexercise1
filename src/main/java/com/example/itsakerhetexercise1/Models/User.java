package com.example.itsakerhetexercise1.Models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
