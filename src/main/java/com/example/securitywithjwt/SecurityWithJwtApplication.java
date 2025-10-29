package com.example.securitywithjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityWithJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityWithJwtApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("1"));

    }

}
