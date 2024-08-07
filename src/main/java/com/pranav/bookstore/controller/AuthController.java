package com.pranav.bookstore.controller;

import com.pranav.bookstore.service.RegisterUserService;
import com.pranav.bookstore.models.AuthUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
public class AuthController {

    @Autowired
    private final RegisterUserService registerUserService;

    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody AuthUser user){
        try {
            registerUserService.registerNewUser(user);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}

