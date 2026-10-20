package com.criser2013.ecommerce.dtos.responses.errors;

import java.util.ArrayList;
import java.util.Map;

import com.criser2013.ecommerce.dtos.responses.Response;

public class ValidationErrorResponse extends Response {
    public ArrayList<String> errorFields;
    public ArrayList<Map<String, String>> details;
    
    
    public ValidationErrorResponse(ArrayList<String> fields, ArrayList<Map<String, String>> details) {
        super("Some fields have invalid values.");
        this.errorFields = fields;
        this.details = details;
    };
}
