package com.example.dio.model;

import jakarta.persistence.*;
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

    @ManyToMany
    private List<Restaurant> restaurants;


}
