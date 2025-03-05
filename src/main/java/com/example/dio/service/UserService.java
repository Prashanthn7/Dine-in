package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.mapper.UserMapper;
import org.mapstruct.factory.Mappers;

public interface UserService {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     *it is the method which is used to register the user data into the database
     *
     * @param registrationRequest it is class which helps to convert
     *                            the Entity class to DTO Data Transfer Object
     * @return                    it returns the Object of the RegistrationRequest
     */
    public UserResponse registerUser(RegistrationRequest registrationRequest);

    /**
     * it is the method used to find the user from database
     *
     * @param userId it is the userId given from the user to match the data in the Database
     * @return the UserResponse Object
     */
    public UserResponse findUserById(long userId);

    /**
     * it is the method used to update the user by the Given id
     *
     * @param userRequest it is the class which allows user to update on only specific fields
     * @param userId it is used to match the user from the database
     * @return it returns the UserReponse object
     */
    public UserResponse updateUserById(UserRequest userRequest, long userId);
}