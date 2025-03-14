package com.example.dio.service.impl;

import com.example.dio.dto.response.CartItemResponse;
import com.example.dio.exception.FoodNotFoundByIdException;
import com.example.dio.exception.TableNotFoundByIdException;
import com.example.dio.mapper.CartItemMapper;
import com.example.dio.model.CartItem;
import com.example.dio.model.FoodItem;
import com.example.dio.model.Table;
import com.example.dio.repository.CartItemRepository;
import com.example.dio.repository.FoodItemRepository;
import com.example.dio.repository.TableRepository;
import com.example.dio.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final TableRepository tableRepository;
    private final FoodItemRepository foodItemRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    @Override
    public CartItemResponse createCartItem(long tableId, long foodId, int quantity) {
        Table table = tableRepository.findById(tableId).orElseThrow(
                ()-> new TableNotFoundByIdException("Table Not Found By ID"));

        FoodItem foodItem = foodItemRepository.findById(foodId)
                .orElseThrow(()-> new FoodNotFoundByIdException("Food Not Found By ID"));

        CartItem cartItem= cartItemRepository.save(getCartItem(table,foodItem,quantity));


        return cartItemMapper.mapToCartItemResponse(cartItem);



    }

    private CartItem getCartItem(Table table, FoodItem foodItem, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setTable(table);
        cartItem.setFoodItem(foodItem);
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(foodItem.getPrice() * quantity);

        return cartItem;
    }


}
