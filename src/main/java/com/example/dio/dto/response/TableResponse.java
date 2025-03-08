package com.example.dio.dto.response;

import com.example.dio.enums.TableStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableResponse {
    private int tableNumber;

    private int tableCapacity;

    private TableStatus status;
}
