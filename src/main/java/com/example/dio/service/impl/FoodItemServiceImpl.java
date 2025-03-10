package com.example.dio.service.impl;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.exception.RestaurantNotFoundByIdException;
import com.example.dio.mapper.FoodItemMapper;
import com.example.dio.model.Category;
import com.example.dio.model.CusineType;
import com.example.dio.model.FoodItem;
import com.example.dio.model.Restaurant;
import com.example.dio.repository.CateroryRepository;
import com.example.dio.repository.CuisineTypeRepository;
import com.example.dio.repository.FoodItemRepository;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.service.FoodItemService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
    private final FoodItemRepository foodItemRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodItemMapper foodItemMapper;
    private final CuisineTypeRepository cuisineTypeRepository;
    private final CateroryRepository cateroryRepository;


    @Override
    @Transactional
    public FoodItemResponse createFoodItem(FoodItemRequest foodItemRequest, long restaurantId) {
        Restaurant restaurant= restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new RestaurantNotFoundByIdException("Restaurant Not Found By Id"));

        FoodItem foodItem= foodItemMapper.mapToNewFoodItemEntity(foodItemRequest);

        CusineType cusineType =foodItem.getCusineType();


        cuisineTypeRepository.findById(cusineType.getCuisine())
                .orElseGet(() -> {
                    cuisineTypeRepository.save(cusineType);
                    restaurant.getCusineTypes().add(cusineType);
                    restaurantRepository.save(restaurant);
                    return cusineType;
                });

        foodItem.setCategories(this.createNonExistingCategory(foodItem.getCategories()));
        foodItem.setCusineType(cusineType);
        foodItem.setRestaurant(restaurant);

        foodItemRepository.save(foodItem);

        return foodItemMapper.mapToFoodItemResponse(foodItem);
    }

    private List<Category> createNonExistingCategory(List<Category> categories) {
        return
        categories.stream().map(type -> cateroryRepository.findById(type.getCategory())
                .orElseGet(()-> cateroryRepository.save(type)))
                .toList();
    }
}
