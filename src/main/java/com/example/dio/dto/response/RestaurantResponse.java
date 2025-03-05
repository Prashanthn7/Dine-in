package com.example.dio.dto.response;

import com.example.dio.enums.DietType;
import com.example.dio.model.CusineType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantResponse {
    private String name;
    private String address;
    private LocalTime opensAt;
    private LocalTime closesAt;
    private DietType dietType;
    private List<String> cuisines;

}
