package com.example.dio.mapper;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.CusineType;
import com.example.dio.model.FoodItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {


    FoodItem mapToNewFoodItemEntity(FoodItemRequest foodItemRequest);

    FoodItemResponse mapToFoodItemResponse(FoodItem foodItem);



    default String mapToStringCuisineType(CusineType cusineType){
        if(cusineType == null){
            return null;
        }
        return cusineType.getCuisine().toLowerCase();
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
