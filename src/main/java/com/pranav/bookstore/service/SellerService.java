package com.pranav.bookstore.service;

import com.pranav.bookstore.models.Seller;
import com.pranav.bookstore.repository.SellerRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    public SellerService(SellerRepository sellerRepository, PasswordEncoder passwordEncoder) {
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Seller registerSeller(Seller seller) {
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        return sellerRepository.save(seller);
    }

    public Seller getSellerByUsername(String username) {
        return sellerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Seller not found with username: " + username));
    }
}