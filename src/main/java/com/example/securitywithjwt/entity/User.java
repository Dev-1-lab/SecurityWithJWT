package com.example.securitywithjwt.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
