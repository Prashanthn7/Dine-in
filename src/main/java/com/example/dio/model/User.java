package com.example.dio.model;

import com.example.dio.enums.UserRole;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "last_modified_date")
    @LastModifiedDate
    private LocalDate lastModifyDate;

    @Column(name ="user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt=LocalDate.now();
//        this.lastModifyDate=LocalDate.now();
//
//    }

}
