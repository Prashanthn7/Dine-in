package com.example.dio.model;

import com.example.dio.enums.DietType;
import com.example.dio.enums.StockStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private long itemId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="stock")
    private int stock;

    @Column(name="availability")
    private StockStatus availability;

    @Column(name="dietType")
    private DietType dietType;

    @Column(name="created_at")
    private LocalDate createdAt;

    @Column(name="last_modified_at")
    private LocalDate lastModifiedAt;

    @ManyToOne
    private CusineType cusineType;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Restaurant restaurant;
}
