package com.example.dio.dto.request;

import com.example.dio.enums.DietType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @NotEmpty
    @NotBlank
    private LocalTime opensAt;

    @NotEmpty
    @NotBlank
    private LocalTime closesAt;

    private List<DietType> dietType;

    @NotEmpty
    @NotBlank
    private List<String> cuisines;

}


