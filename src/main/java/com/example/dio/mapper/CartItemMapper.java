package com.example.dio.mapper;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.model.CartItem;
import com.example.dio.model.Category;
import com.example.dio.model.CusineType;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    CartItemResponse mapToCartItemResponse(CartItem cartItem);
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

    default List<String> mapToListOfStringCategories(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        return categories.stream()
                .map(Category::getCategory)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    default List<Category> mapToListOfCategories(List<String> categoryNames) {
        if (categoryNames == null) {
            return null;
        }
        return categoryNames.stream()
                .map(name -> {
                    Category category = new Category();
                    category.setCategory(name);
                    return category;
                })
                .collect(Collectors.toList());
    }

}
