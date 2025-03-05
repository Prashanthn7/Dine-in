package com.example.dio.mapper;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    void mapToRestaurantEntity(RestaurantRequest restaurantRequest,@MappingTarget Restaurant restaurant);
    RestaurantResponse mapToRestaurantResponse(Restaurant restaurant);
}
