package com.criser2013.ecommerce.dtos.responses;

import java.util.ArrayList;
import java.util.Map;

public class ValidationErrorResponse extends Response {
    public ArrayList<String> errorFields;
    public ArrayList<Map<String, String>> details;
    
    
    public ValidationErrorResponse(ArrayList<String> fields, ArrayList<Map<String, String>> details) {
        super("Some fields have invalid values.");
        this.errorFields = fields;
        this.details = details;
    };
}
