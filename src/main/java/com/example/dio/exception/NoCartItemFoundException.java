package com.example.dio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoCartItemFoundException extends RuntimeException{
    private String message;
}
