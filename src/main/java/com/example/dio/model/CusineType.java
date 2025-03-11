package com.example.dio.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="cuisines")
public class CusineType {

    @Id
    private String cuisine;

    @ManyToMany(mappedBy = "cusineTypes")
    private List<Restaurant> restaurants;

    @OneToMany(mappedBy = "cusineType")
    private List<FoodItem> foodItems;


}
