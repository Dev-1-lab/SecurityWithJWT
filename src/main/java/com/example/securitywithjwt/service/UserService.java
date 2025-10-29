package com.example.securitywithjwt.service;

import com.example.securitywithjwt.dto.LoginRequest;
import com.example.securitywithjwt.dto.UserDTO;
import com.example.securitywithjwt.entity.User;
import com.example.securitywithjwt.entity.UserRole;
import com.example.securitywithjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String register(UserDTO userDTO) {
        User user = User
                .builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .role(UserRole.ROLE_USER)
                .build();
        userRepository.save(user);
        return "Foydalanuvchi muvaffaqiyatli qo'shildi";
    }

    public String verify(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        }

        throw new RuntimeException("Authentication failed");
    }
}
