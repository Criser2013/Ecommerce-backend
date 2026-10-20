package com.criser2013.ecommerce.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.criser2013.ecommerce.dtos.requests.NewUserRequest;
import com.criser2013.ecommerce.dtos.responses.SignupResponse;
import com.criser2013.ecommerce.models.User;
import com.criser2013.ecommerce.services.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/auth/signup")
    public ResponseEntity<SignupResponse> signUp(
        @Valid @RequestBody NewUserRequest newUser
    ) {
        User user = authService.signUp(newUser);
        SignupResponse response = new SignupResponse(
                user.id,
                user.roleId.id,
                user.status);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
