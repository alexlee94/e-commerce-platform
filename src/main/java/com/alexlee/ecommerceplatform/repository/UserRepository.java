package com.alexlee.ecommerceplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alexlee.ecommerceplatform.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

