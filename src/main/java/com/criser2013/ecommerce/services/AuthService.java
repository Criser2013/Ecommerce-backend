package com.criser2013.ecommerce.services;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.stereotype.Service;

import com.criser2013.ecommerce.dtos.requests.NewUserRequest;
import com.criser2013.ecommerce.repositories.UserRepository;

@Service 
public class AuthService {
    private final UserRepository userRepository;
    private static final String EMAIL_REGEX = ;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean signUp(NewUserRequest newUser) throws PatternSyntaxException {
        
    }
}
