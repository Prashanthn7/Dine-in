package com.example.dio.model;

import com.example.dio.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private long userId;

    @Column(name="user_name")
    private String username;

    @Column(name="user_email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_number")
    private String phoneNo;

    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_date")
    private LocalDate lastModifyDate;

    @Column(name ="user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
