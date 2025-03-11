package com.example.dio.service;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;

public interface RestaurantService {

    public RestaurantResponse registerRestaurant(RestaurantRequest restaurantRequest,long userId);
}
