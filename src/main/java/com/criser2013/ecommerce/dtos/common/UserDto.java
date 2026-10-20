package com.criser2013.ecommerce.dtos.common;

import java.time.LocalDate;

import com.criser2013.ecommerce.models.Role;
import com.criser2013.ecommerce.models.SecurityQuestion;

public record UserDto (
    Long userId,
    Role role,
    SecurityQuestion question,
    String email,
    String firstName,
    String lastName,
    LocalDate registrationDate,
    String phone,
    String dni,
    String password,
    String securityAnswer,
    Long status
) {}
