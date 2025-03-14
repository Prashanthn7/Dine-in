package com.example.dio.controller;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.service.CartItemService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping("/tables/{tableId}/cartItem/foodItems/{foodId}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> createCartItem(@PathVariable long tableId,
                                                                             @PathVariable long foodId,
                                                                             @RequestParam int quantity){
        CartItemResponse response = cartItemService.createCartItem(tableId,foodId,quantity);

        return ResponseBuilder.created(response,"CartItem Created");
    }

}
