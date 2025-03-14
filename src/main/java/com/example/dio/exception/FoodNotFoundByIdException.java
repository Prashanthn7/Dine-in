package com.example.dio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodNotFoundByIdException extends RuntimeException{
    private String message;
}
