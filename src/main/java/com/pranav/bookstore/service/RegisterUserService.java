package com.pranav.bookstore.service;

import com.pranav.bookstore.models.AuthUser;
import com.pranav.bookstore.repository.AuthUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterUserService {
    @Autowired
    private final AuthUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUser(AuthUser user) throws Exception {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("User already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
