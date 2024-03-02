package com.rsn.backend.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    @Email(message = "Invakid email provided")
    private String email;

    @Column(name = "password")
    private String password;
}
