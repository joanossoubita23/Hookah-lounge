package com.hookah.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private  Long id;
    @Column(nullable = false,unique = true)
    private  String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;

}
