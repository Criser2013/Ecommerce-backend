package com.criser2013.ecommerce.dtos.responses;

import java.util.Optional;

public class SignupResponse {
    public Boolean success;
    public String error = null;
    public Optional<Long> accountId;
    public Optional<Long> role;
    public Optional<Long> status;
}
