package com.example.dio.service.impl;

import com.example.dio.dto.request.RestaurantRequest;
import com.example.dio.dto.response.RestaurantResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.exception.UserUnautherized;
import com.example.dio.mapper.RestaurantMapper;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.CusineType;
import com.example.dio.model.Restaurant;
import com.example.dio.model.User;
import com.example.dio.repository.CuisineTypeRepository;
import com.example.dio.repository.RestaurantRepository;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final CuisineTypeRepository cuisineTypeRepository;
    private final RestaurantMapper restaurantMapper;

    @Override
    public RestaurantResponse registerRestaurant(RestaurantRequest restaurantRequest, long userId) {
    User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundByIdException("User not found by id"));
    if(user instanceof Admin admin ){
       Restaurant restaurant= restaurantMapper.mapToRestaurantEntity(restaurantRequest);
        List<CusineType> cuisineTypes = restaurant.getCusineTypes();
        restaurant.setCusineTypes(CuisineExistOrNot(cuisineTypes));
        restaurant.setAdmin(admin);
        restaurantRepository.save(restaurant);

       return restaurantMapper.mapToRestaurantResponse(restaurant);
    }
    else{
        throw new UserUnautherized("User is not autherized to register an Restaurant!");
    }

    }

    private List<CusineType> CuisineExistOrNot(List<CusineType> cuisineTypes) {
       return cuisineTypes.stream().map(
                type ->
                    cuisineTypeRepository.findById(type.getCuisine()).orElseGet(
                            () -> {
                                type.setCuisine(type.getCuisine().toLowerCase());
                                cuisineTypeRepository.save(type);
                                return type;
                            }))
               .toList();
    }
}
