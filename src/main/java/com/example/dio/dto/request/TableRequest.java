package com.example.dio.dto.request;

import com.example.dio.enums.TableStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequest {

    @NotEmpty(message ="table number should not be empty")
    @NotBlank
    @Pattern(regexp = "^[0-9]//d{10}$")
    private int tableNumber;

    @NotEmpty(message = "table's capacity should not be empty")
    @Pattern(regexp = "^[0-9]//d{2}$")
    private int tableCapacity;



}
