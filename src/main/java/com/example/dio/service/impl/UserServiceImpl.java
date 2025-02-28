package com.example.dio.service.impl;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {

        User user=this.createUserByRole(registrationRequest.getUserRole());
        this.mapToUserEntity(user,registrationRequest);
        userRepository.save(user);
        return this.mapToUserResponse(user);
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .userRole(user.getUserRole())
                .createdAt(user.getCreatedAt())
                .lastModifyDate(user.getLastModifyDate())
                .build();
    }

    @Override
    public UserResponse findUserById(long userId) {
        User user= userRepository.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("Couldn't Find User By id"));
      return this.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUserById(UserRequest userRequest, long userId) {
     User exuser=  userRepository.findById(userId).orElseThrow(()-> new UserNotFoundByIdException("Couldnot find the user by id"));
      this.mapToNewUser(userRequest,exuser);

      userRepository.save(exuser);
      return this.mapToUserResponse(exuser);
    }

    private void mapToUserEntity(User user,RegistrationRequest registrationRequest ){
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setPhoneNo(registrationRequest.getPhoneNo());
        user.setUserRole(registrationRequest.getUserRole());

    }
    private void mapToNewUser(User source,User target) {
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setPhoneNo(source.getPhoneNo());
        target.setUserRole(source.getUserRole());
    }
    private void mapToNewUser(UserRequest source,User target) {
        target.setUsername(source.getUsername());
        target.setEmail(source.getEmail());
        target.setPhoneNo(source.getPhoneNo());
    }

    private User createUserByRole(UserRole role) {
        User user = null;
        switch (role) {
          case ADMIN ->  user = new Admin();
          case STAFF ->  user = new Staff();
          default -> new RuntimeException("Failed to Register the User || Invalid User");
        }
        return user;
    }
}
