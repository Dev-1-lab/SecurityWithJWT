package com.example.securitywithjwt.controller;

import com.example.securitywithjwt.dto.AuthResponse;
import com.example.securitywithjwt.dto.LoginRequest;
import com.example.securitywithjwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authService.authenticate(
                loginRequest.getUsername(),
                loginRequest.getPassword());
        String token = authService.generateToken(userDetails);
        AuthResponse authResp = AuthResponse
                .builder()
                .token(token)
                .success(true)
                .build();
        return ResponseEntity.ok(authResp);
    }





}
