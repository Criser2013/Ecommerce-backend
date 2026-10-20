package com.criser2013.ecommerce.dtos.responses;

/**
 * Class to represent a successful signup response.
 * SignupResponse
 */
public class SignupResponse extends Response {
    public final Long accountId;
    public final Long role;
    public final Long status;

    public SignupResponse(Long accountId, Long role, Long status) {
        super();
        this.role = role;
        this.status = status;
        this.accountId = accountId;
    }
}
