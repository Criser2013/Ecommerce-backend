package com.criser2013.ecommerce.dtos.responses;

import java.util.Optional;

public record SignupResponse (
    Boolean success,
    String error,
    Optional<Long> accountId,
    Optional<Long> role,
    Optional<Long> status
) {}
