package com.criser2013.ecommerce.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.criser2013.ecommerce.dtos.requests.NewUserRequest;
import com.criser2013.ecommerce.dtos.responses.SignupResponse;
import com.criser2013.ecommerce.models.User;
import com.criser2013.ecommerce.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {
    private  final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @PostMapping("/api/auth/signup")
    public SignupResponse signUp(@RequestBody NewUserRequest newUser) {
        
        userRepository.save(
            new User()
        );
        
        return ;
    }
    

}
