package com.example.dio.controller;

import com.example.dio.dto.request.FoodItemRequest;
import com.example.dio.dto.response.FoodItemResponse;
import com.example.dio.service.FoodItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class FoodItemController {
    private final FoodItemService foodItemService;

    @PostMapping("/foodItems/restaurant/{restaurantId}")
    public ResponseEntity<ResponseStructure<FoodItemResponse>> createFoodItem(@RequestBody FoodItemRequest foodItemRequest, @PathVariable long restaurantId){
        FoodItemResponse response = foodItemService.createFoodItem(foodItemRequest,restaurantId);

        return ResponseBuilder.created(response,"FoodItem Created!");
    }

     @GetMapping("/foodItems")
     public ResponseEntity<ResponseStructure<List<FoodItemResponse>>> findFoodItemsByAllCategories(
             @RequestParam List<String> categories) {

         List<FoodItemResponse> foodItems = foodItemService.findFoodItemByAllCategories(categories);

         if (foodItems.isEmpty()) {
             return ResponseBuilder.success(HttpStatus.NOT_FOUND, "No food items found matching all categories", List.of());
         }

         return ResponseBuilder.ok(foodItems, "Found food items matching all categories");
     }


}
