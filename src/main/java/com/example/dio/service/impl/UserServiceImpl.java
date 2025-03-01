package com.example.dio.service.impl;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
 public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {

        User user=this.createUserByRole(registrationRequest.getUserRole());
        userMapper.mapToUserEntity(user,registrationRequest);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }



    @Override
    public UserResponse findUserById(long userId) {
        User user= userRepository.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("Couldn't Find User By id"));
      return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUserById(UserRequest userRequest, long userId) {
     User exuser=  userRepository.findById(userId).orElseThrow(()-> new UserNotFoundByIdException("Couldnot find the user by id"));
      userMapper.mapToNewUser(userRequest,exuser);

      userRepository.save(exuser);
      return userMapper.mapToUserResponse(exuser);
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
