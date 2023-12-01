package com.example.springdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestDTO {
    private String email;
    private String password;
}