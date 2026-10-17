package com.criser2013.ecommerce.dtos;

import java.util.Optional;

public class AddressDto {
    public Optional<Long> id;
    public String address;
    public Boolean isDefault;
    public ZipcodeDto zipcode;
}
