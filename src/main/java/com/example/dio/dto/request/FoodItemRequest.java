package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class FoodItemRequest {
        private String name;
        private double price;
        private String description;
        private int stock;
        private DietType dietType;
        private String cusineType;

    }

