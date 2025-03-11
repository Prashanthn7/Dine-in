package com.example.dio.controller;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.service.RestaurantService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class RestaurantController {

    private RestaurantService restaurantService;

    @PostMapping("/register/{userId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> registerRestaurant(@RequestBody@Valid RestaurantRequest restaurantRequest,@PathVariable long userId){
        RestaurantResponse response = restaurantService.registerRestaurant(restaurantRequest,userId);

        return ResponseBuilder.success(HttpStatus.CREATED,"Restaurant registered",response);

    }


}
