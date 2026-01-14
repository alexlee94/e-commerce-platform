package com.alexlee.ecommerceplatform.controller;

import com.alexlee.ecommerceplatform.security.JwtService;
import com.alexlee.ecommerceplatform.service.UserService;
import com.alexlee.ecommerceplatform.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userService.findByUsername(request.getUsername())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> ResponseEntity.ok(jwtService.generateToken(user.getUsername())))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}


