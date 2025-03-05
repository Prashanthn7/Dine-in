package com.example.dio.model;

import com.example.dio.model.enums.DietType;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

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

    @Column()
    private String contactEmail;

    private LocalTime opensAt;
    private LocalTime closesAt;
    private DietType dietType;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;

}
