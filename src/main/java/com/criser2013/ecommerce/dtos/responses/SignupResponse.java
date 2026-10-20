package com.criser2013.ecommerce.dtos.responses;

import java.util.Optional;

public class SignupResponse extends Response {
    public final Boolean success;
    public final Optional<String> error;
    public final Optional<Long> accountId;
    public final Optional<Long> role;
    public final Optional<Long> status;

    public SignupResponse(String error) {
        this.success = false;
        this.error = Optional.ofNullable(error);
        this.accountId = null;
        this.role = null;
        this.status = null;
    }

    public SignupResponse(Long accountId, Long role, Long status) {
        this.success = true;
        this.error = null;
        this.role = Optional.ofNullable(role);
        this.status = Optional.ofNullable(status);
        this.accountId = Optional.ofNullable(accountId);
    }
}
