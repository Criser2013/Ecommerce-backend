package com.criser2013.ecommerce.dtos.common;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AddressDto {
    public Long id;

    @Pattern (regexp = "^[A-Za-z]+\s[0-9]+([A-Za-z]\s[A-Za-z]{3})*-[0-9]+(\s[A-Za-z]\s[0-9])*$")
    public String address;

    @NotNull 
    public Boolean isDefault;

    @NotNull
    public ZipcodeDto zipcode;
}
