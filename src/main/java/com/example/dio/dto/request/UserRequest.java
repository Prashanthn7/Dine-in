package com.example.dio.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class UserRequest {
    @NotNull
    @NotBlank
    private String username;
    private String email;
    private String phoneNo;
}
