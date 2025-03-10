package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FoodItemResponse {
    private String name;
    private double price;
    private String description;
    private DietType dietType;
    private String cusineType;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
}
