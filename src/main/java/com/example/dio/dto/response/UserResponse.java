package com.example.dio.dto.response;

import com.example.dio.enums.UserRole;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private long userId;
    private String username;
    private UserRole userRole;
    private LocalDate createdAt;
    private LocalDate lastModifyDate;

}
