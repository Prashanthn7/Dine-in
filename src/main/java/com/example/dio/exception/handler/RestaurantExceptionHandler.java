package com.example.dio.exception.handler;

import com.example.dio.exception.FoodNotFoundByIdException;
import com.example.dio.exception.RestaurantNotFoundByIdException;
import com.example.dio.exception.TableNotFoundByIdException;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.SimpleErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantExceptionHandler {

    @ExceptionHandler(RestaurantNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> handleSimpleErrorResponse(RestaurantNotFoundByIdException ex){
        return ResponseBuilder.notFound(ex.getMessage());
    }

    @ExceptionHandler(FoodNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> handleSimpleErrorResponse(FoodNotFoundByIdException ex){
        return ResponseBuilder.notFound(ex.getMessage());
    }

    @ExceptionHandler(TableNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> handleSimpleErrorResponse(TableNotFoundByIdException ex){
        return ResponseBuilder.notFound(ex.getMessage());
    }
}
