package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public  interface UserMapper {
     void mapToUserEntity(@MappingTarget User user, RegistrationRequest registrationRequest );

     void mapToNewUser(UserRequest source, @MappingTarget User target);

     UserResponse mapToUserResponse(User user);
}
