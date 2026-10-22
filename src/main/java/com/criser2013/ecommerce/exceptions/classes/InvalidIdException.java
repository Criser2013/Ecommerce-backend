package com.criser2013.ecommerce.exceptions.classes;

public class InvalidIdException extends RuntimeException {
    public String error;

    public InvalidIdException(Long id) {
        this.error = "The provided ID '" + id.toString() + "' doesn't exists.";
    }
}
