package com.example.dio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String email;
    private String password;
    private long phoneno;
    private LocalDate createdAt;
    private LocalDate lastModifyDate;
    private String userRole;

}
