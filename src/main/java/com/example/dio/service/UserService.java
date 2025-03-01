package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.mapper.UserMapper;
import org.mapstruct.factory.Mappers;

public interface UserService {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public UserResponse registerUser(RegistrationRequest registrationRequest);

    public UserResponse findUserById(long userId);

    public UserResponse updateUserById(UserRequest userRequest, long userId);
}