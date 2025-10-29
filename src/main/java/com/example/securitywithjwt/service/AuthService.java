package com.example.securitywithjwt.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    String generateToken(UserDetails userDetails);
    UserDetails authenticate(String username, String password);
    UserDetails validateToken(String token);
}
