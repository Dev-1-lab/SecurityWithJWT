package com.example.securitywithjwt.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
}