package com.criser2013.ecommerce.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.criser2013.ecommerce.dtos.requests.NewUserRequest;
import com.criser2013.ecommerce.dtos.responses.SignupResponse;
import com.criser2013.ecommerce.models.User;
import com.criser2013.ecommerce.services.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/api/auth/signup")
    public SignupResponse signUp(@Valid  @RequestBody NewUserRequest newUser) {
        try {
            User user = this.authService.signUp(newUser);
            return new SignupResponse(user.id, user.roleId.id, user.status);
        } catch (Error e) {
            return new SignupResponse(e.toString());
        }
    }
    

}
