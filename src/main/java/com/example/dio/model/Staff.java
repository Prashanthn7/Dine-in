package com.example.dio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "staffs")
@Getter
@Setter
public class Staff extends User{

    @ManyToMany(mappedBy = "staffs")
    private List<com.example.dio.model.Table> tables;
}
