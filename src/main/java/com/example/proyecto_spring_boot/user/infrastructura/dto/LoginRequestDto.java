package com.example.proyecto_spring_boot.user.infrastructura.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String user;
    private String password;
}
