package com.alexlee.ecommerceplatform.service;

import com.alexlee.ecommerceplatform.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User saveUser(User user);
}

