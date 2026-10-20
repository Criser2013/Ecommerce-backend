package com.criser2013.ecommerce.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.criser2013.ecommerce.dtos.common.AddressDto;

public class NewUserRequest {
    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zñÑáéíóúÁÉÍÓÚ\s]+$")
    @Size(min = 6, max = 100)
    public String firstName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-zñÑáéíóúÁÉÍÓÚ\s]+$")
    @Size(min = 6, max = 100)
    public String lastName;

    @NotNull
    public AddressDto address;

    @NotNull
    public Long questionId;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    public String phone;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 6)
    public String dni;

    @NotBlank
    @Size(min = 12)
    public String password;

    @NotBlank
    @Size(min = 3, max = 200)
    @Pattern (regexp = "^[a-zA-Z\sñÑáéíóúÁÉÍÓÚ0-9]+$")
    public String securityAnswer;
}
