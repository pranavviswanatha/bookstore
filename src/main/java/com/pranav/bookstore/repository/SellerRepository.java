package com.pranav.bookstore.repository;

import com.pranav.bookstore.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SellerRepository extends MongoRepository<Seller, String> {
    Optional<Seller> findByUsername(String username);
}
