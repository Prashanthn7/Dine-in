package com.example.dio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartNotFoundByIdException extends RuntimeException{
    private String message;
}
