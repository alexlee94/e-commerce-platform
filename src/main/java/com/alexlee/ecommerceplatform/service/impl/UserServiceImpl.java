package com.alexlee.ecommerceplatform.service.impl;

import com.alexlee.ecommerceplatform.model.User;
import com.alexlee.ecommerceplatform.repository.UserRepository;
import com.alexlee.ecommerceplatform.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

