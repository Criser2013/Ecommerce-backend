package com.criser2013.ecommerce.dtos.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ZipcodeDto {
    @NotBlank
    @Pattern (regexp="^[0-9]{9}$")
    public String zipcode;

    @Pattern(regexp = "^[A-Za-z ñÑáéíóúÁÉÍÓÚ]$")
    @Size (min=3, max= 100)
    public String city;

    @Pattern(regexp = "^[A-Za-z ñÑáéíóúÁÉÍÓÚ]$")
    @Size (min=4, max= 50)
    public String country;

    @Pattern(regexp = "^[A-Za-z ñÑáéíóúÁÉÍÓÚ]$")
    @Size (min=3, max= 50)
    public String district;

    @Pattern(regexp = "^[A-Za-z ñÑáéíóúÁÉÍÓÚ]$")
    @Size (min=3, max= 100)
    public String state;
}
