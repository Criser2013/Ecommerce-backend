package com.criser2013.ecommerce.exceptions.classes;

public class DuplicatedEmailException extends RuntimeException {
    public String error;

    public DuplicatedEmailException(String email) {
        this.error = "The provided email: '" + email + "' is alredy registered.";
    }
}
