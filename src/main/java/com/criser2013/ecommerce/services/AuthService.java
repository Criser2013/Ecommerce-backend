package com.criser2013.ecommerce.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.criser2013.ecommerce.dtos.common.ZipcodeDto;
import com.criser2013.ecommerce.dtos.requests.NewUserRequest;
import com.criser2013.ecommerce.exceptions.classes.DuplicatedEmailException;
import com.criser2013.ecommerce.exceptions.classes.InvalidIdException;
import com.criser2013.ecommerce.models.User;
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

    public AuthService(UserRepository userRepository, AddressRepository addressRepository,
            ZipcodeRepository zipcodeRepository, SecurityQuestionRepository questionRepository,
            SecurityQuestionRepository securityQuestionRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.zipcodeRepository = zipcodeRepository;
        this.roleRepository = roleRepository;
        this.securityQuestionRepository = securityQuestionRepository;
    }

    /**
     * Method to register new users.
     * 
     * @param newUser New user instance.
     * @return Registered user instance.
     */
    public User signUp(NewUserRequest newUser) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean isEmailRegistered = userRepository.findByEmail(newUser.email) != null;

        if (isEmailRegistered) {
            throw new DuplicatedEmailException(newUser.email);
        }

        String encodedPassword = encoder.encode(newUser.password);
        String encodedSecurityAnswer = encoder.encode(newUser.securityAnswer);
        Role roleInstance = roleRepository.findById(Long.valueOf(2)).get();
        Optional<SecurityQuestion> questionInstance = securityQuestionRepository.findById(newUser.questionId);

        if (!questionInstance.isPresent()) {
            throw new InvalidIdException(newUser.questionId, "questionId");
        }

        Zipcode zipcodeInstance = null;

        ZipcodeDto userZipcode = newUser.address.zipcode;
        boolean existsZipcode = zipcodeRepository.existsById(userZipcode.zipcode);

        if (existsZipcode) {
            zipcodeInstance = zipcodeRepository.findByZipcode(userZipcode.zipcode);
        } else {
            zipcodeInstance = zipcodeRepository.save(
                    new Zipcode(
                            userZipcode.zipcode,
                            userZipcode.city,
                            userZipcode.country,
                            userZipcode.district,
                            userZipcode.state));
        }

        User userInstance = userRepository.save(
                new User(
                        roleInstance,
                        questionInstance.get(),
                        newUser.firstName,
                        newUser.lastName,
                        newUser.email,
                        newUser.phone,
                        newUser.dni,
                        encodedPassword,
                        encodedSecurityAnswer));

        addressRepository.save(
                new Address(
                        userInstance,
                        zipcodeInstance,
                        newUser.address.address,
                        true));

        return userInstance;
    }
}
