package com.example.dio.service.impl;

import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        User user2=this.createUserByRole(user.getUserRole());
        this.mapToNewUser(user,user2);
        return userRepository.save(user2);
    }

    @Override
    public User findUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("Couldn't Find User By id"));
    }

    @Override
    public User updateUserById(User user, long userId) {
     User exuser=  userRepository.findById(userId).orElseThrow(()-> new UserNotFoundByIdException("Couldnot find the user by id"));
      this.mapToNewUser(user,exuser);

      return userRepository.save(exuser);
    }

    private void mapToNewUser(User user,User user2) {
        user2.setUsername(user.getUsername());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setPhoneNo(user.getPhoneNo());
        user2.setUserRole(user.getUserRole());
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
