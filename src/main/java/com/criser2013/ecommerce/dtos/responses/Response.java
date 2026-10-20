package com.criser2013.ecommerce.dtos.responses;

public class Response {
    public Boolean success;
    public String error;

    public Response() {
        this.success = true;
        this.error = null;
    }

    public Response(String error) {
        this.success = false;
        this.error = error;
    }
}
