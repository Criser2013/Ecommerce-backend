package com.criser2013.ecommerce.services;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Service;

import com.criser2013.ecommerce.dtos.requests.NewUserRequest;
import com.criser2013.ecommerce.models.Address;
import com.criser2013.ecommerce.models.Role;
import com.criser2013.ecommerce.models.SecurityQuestion;
import com.criser2013.ecommerce.models.Zipcode;
import com.criser2013.ecommerce.repositories.AddressRepository;
import com.criser2013.ecommerce.repositories.RoleRepository;
import com.criser2013.ecommerce.repositories.SecurityQuestionRepository;
import com.criser2013.ecommerce.repositories.UserRepository;
import com.criser2013.ecommerce.repositories.ZipcodeRepository;

@Service
public class AuthService {
    private final SecurityQuestionRepository securityQuestionRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ZipcodeRepository zipcodeRepository;
    private final RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, AddressRepository addressRepository, ZipcodeRepository zipcodeRepository, SecurityQuestionRepository questionRepository, SecurityQuestionRepository securityQuestionRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.zipcodeRepository = zipcodeRepository;
        this.roleRepository = roleRepository;
        this.securityQuestionRepository = securityQuestionRepository;
    }

    public Boolean signUp(NewUserRequest newUser) throws PatternSyntaxException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(newUser.password);
        String encodedSecurirtyAnswer = encoder.encode(newUser.securityAnswer);

        Role userRole = roleRepository.findByRoleId(Long.valueOf(2));
        SecurityQuestion userQuestion = securityQuestionRepository.findBySecurityId(newUser.questionId);

        boolean existsZipcode = zipcodeRepository.existsById(newUser.address.zipcode.zipcode());
        Zipcode userZipcode = null;

        if (!existsZipcode) {
            Zipcode userZipcode = existsZipcode ? zipcodeRepository.findById(newUser.address.zipcode.zipcode());
        }


        User userInstance = new User(
            userRole,

        );

        Address userAddress = new Address(
            userInstance,

        );


        return true;
    }
}
