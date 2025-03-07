package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import com.example.dio.model.CusineType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message ="Restaurant name can only contain Alphabets, Number and Underscore")
    private String name;

    @NotEmpty
    @NotBlank
    private String address;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "phone number should contain 10 digits")
    private String contactNumber;

    @NotEmpty(message = "Email Should Not Be Empty")
    @NotBlank(message = "Email should not be blank")
    @Email(regexp = "^[a-zA-Z0-9._]+@gmail.com$")
    private String contactEmail;

    @NotNull(message = "opening time should not be null")
    private LocalTime opensAt;


    @NotNull(message = "closing time should not be null")
    private LocalTime closesAt;

    @NotEmpty(message = "Diet Type should not be empty")
    private List<DietType> dietTypes;

    @NotEmpty(message = "cuisine Type should not be empty")
    private List<String> cusineTypes;


}


