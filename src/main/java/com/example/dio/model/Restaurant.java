package com.example.dio.model;

import com.example.dio.enums.DietType;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="restaurants")
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="restaurant_id")
    private long restaurantId;

    @Column(name ="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="contact_number")
    private String contactNumber;

    @Column(name ="contact_email")
    private String contactEmail;

    @Column(name ="opens_at")
    private LocalTime opensAt;

    @Column(name ="closes_at")
    private LocalTime closesAt;

    @Column(name ="diet_type")
    private List<DietType> dietTypes;

    @Column(name ="created_at")
    private LocalDate createdAt;

    @Column(name ="last_modify_at")
    private LocalDate lastModifiedAt;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<CusineType> cusineTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @OneToMany(mappedBy = "restaurant")
    private List<com.example.dio.model.Table> tables;

    @OneToMany(mappedBy = "restaurant")
    private List<FoodItem> foodItems;

}
