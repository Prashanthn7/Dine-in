package com.example.dio.mapper;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.model.CusineType;
import com.example.dio.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant mapToRestaurantEntity(RestaurantRequest restaurantRequest);
    RestaurantResponse mapToRestaurantResponse(Restaurant restaurant);
    default String mapToStringCuisineType(CusineType cusineType){
        if(cusineType == null){
            return null;
        }
        return cusineType.getCuisine();
    }
    default CusineType mapToCuisineType(String cusineType){
        if(cusineType == null){
            return null;
        }
        CusineType cuisine = new CusineType();
        cuisine.setCuisine(cusineType);
        return cuisine;

    }
}
