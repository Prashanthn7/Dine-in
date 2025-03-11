package com.example.dio.mapper;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.model.Category;
import com.example.dio.model.CusineType;
import com.example.dio.model.FoodItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodItemMapper {


    FoodItem mapToNewFoodItemEntity(FoodItemRequest foodItemRequest);
    List<Category> mapToListOfCategory(List<String> categories);
    FoodItemResponse mapToFoodItemResponse(FoodItem foodItem);

    List<FoodItemResponse> mapToFoodItemResponseList(List<FoodItem> foodItems);

    default String mapToStringCategories(Category category) {
        if (category == null) {
            return null;
        }
        return category.getCategory().toLowerCase();
    }

    default Category mapToCategory(String category) {
        if (category == null) {
            return null;
        }
        Category category1 = new Category();
        category1.setCategory(category);
        return category1;
    }


    default String mapToStringCuisineType(CusineType cusineType) {
        if (cusineType == null) {
            return null;
        }
        return cusineType.getCuisine().toLowerCase();
    }

    default CusineType mapToCuisineType(String cusineType) {
        if (cusineType == null) {
            return null;
        }
        CusineType cuisine = new CusineType();
        cuisine.setCuisine(cusineType);
        return cuisine;

    }
}

