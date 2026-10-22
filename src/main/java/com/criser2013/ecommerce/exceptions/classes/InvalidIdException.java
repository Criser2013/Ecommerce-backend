package com.criser2013.ecommerce.exceptions.classes;

public class InvalidIdException extends RuntimeException {
    public String error;

    public InvalidIdException(Long id, String field) {
        this.error = "The provided ID '" + id.toString() + "' at field '" + field + "' doesn't exists.";
    }
}
