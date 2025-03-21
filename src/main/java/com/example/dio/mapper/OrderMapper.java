package com.example.dio.mapper;

import com.example.dio.dto.response.OrderResponse;
import com.example.dio.model.Category;
import com.example.dio.model.CusineType;
import com.example.dio.model.Order;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse mapToOrderResponse(Order order);

    default List<String> mapToListOfStringCategories(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        return categories.stream()
                .map(Category::getCategory)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
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
