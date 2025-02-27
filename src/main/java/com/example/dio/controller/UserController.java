package com.example.dio.controller;

import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
       user = userService.registerUser(user);

       ResponseStructure<User> structure= ResponseStructure.<User>builder()
               .status(HttpStatus.CREATED.value())
               .message("User Created")
               .data(user)
               .build();
       return ResponseEntity.status(HttpStatus.CREATED).body(structure);

    }
}
