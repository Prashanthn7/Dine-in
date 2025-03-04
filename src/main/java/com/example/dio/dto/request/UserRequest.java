package com.example.dio.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "Username Cannot Be Null or Blank")
    private String username;
    private String email;
    private String phoneNo;
}
