package com.example.dio.mapper;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public void mapToUserEntity(User user, RegistrationRequest registrationRequest ){
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setPhoneNo(registrationRequest.getPhoneNo());
        user.setUserRole(registrationRequest.getUserRole());

    }

    public void mapToNewUser(UserRequest source, User target) {
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        target.setPhoneNo(source.getPhoneNo());
    }
    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .userRole(user.getUserRole())
                .createdAt(user.getCreatedAt())
                .lastModifyDate(user.getLastModifyDate())
                .build();
    }
}
