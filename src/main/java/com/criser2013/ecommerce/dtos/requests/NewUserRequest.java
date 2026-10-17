package com.criser2013.ecommerce.dtos.requests;

import com.criser2013.ecommerce.dtos.common.AddressDto;

public class NewUserRequest {
    public String firstName;
    public String lastName;
    public AddressDto address;
    public Long questionId;
    public String phone;
    public String dni;
    public String email;
    public String password;
    public Long securityQuestion;
    public String securityAnswer;
}
