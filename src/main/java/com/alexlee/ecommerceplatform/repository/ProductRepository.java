package com.alexlee.ecommerceplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alexlee.ecommerceplatform.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
