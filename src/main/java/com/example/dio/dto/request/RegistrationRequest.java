package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {
    @NotEmpty(message = "Username Cannot Be Null or Blank")
    @NotBlank(message = "Email should not be blank")
    private String username;

    @NotEmpty(message = "Email Should Not Be Empty")
    @NotBlank(message = "Email should not be blank")
    private String email;
    private String password;
    private String phoneNo;
    private UserRole userRole;
}
