package com.example.securitywithjwt.controller;

import com.example.securitywithjwt.dto.LoginRequest;
import com.example.securitywithjwt.dto.LoginResponse;
import com.example.securitywithjwt.dto.UserDTO;
import com.example.securitywithjwt.entity.User;
import com.example.securitywithjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = userService.verify(request);
        return ResponseEntity.ok(
                LoginResponse.builder()
                        .token(token)
                        .message("Login successful")
                        .build());
    }
}