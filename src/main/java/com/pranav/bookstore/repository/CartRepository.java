package com.pranav.bookstore.repository;

import com.pranav.bookstore.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByUsername(String username);
}
