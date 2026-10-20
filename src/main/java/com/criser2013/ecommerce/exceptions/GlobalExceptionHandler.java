
package com.criser2013.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.criser2013.ecommerce.dtos.responses.Response;
import com.criser2013.ecommerce.dtos.responses.ValidationErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handler for request validation errors.
     * 
     * @param ex {MethodArgumentNotValidException} Validation exception instance.
     * @return {ResponseEntity<ValidationErrorResponse>} HTTP response instance.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        ArrayList<String> fields = new ArrayList<String>();
        ArrayList<Map<String, String>> details = new ArrayList<Map<String, String>>();

        for (FieldError error : errors) {
            String fieldName = error.getField();
            String errorDetail = error.getDefaultMessage();
            Map<String, String> detail = new HashMap<String, String>();

            fields.add(fieldName);
            detail.put("field", fieldName);
            detail.put("detail", errorDetail);
            details.add(detail);
        }

        ValidationErrorResponse res = new ValidationErrorResponse(fields, details);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(res);
    }

    /**
     * Handler for general exceptions.
     * 
     * @param ex {Exception} Exception thrown.
     * @return {ResponseEntity<Response>} Response instance.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGeneral(Exception ex) {
        Response res = new Response(ex.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }
}
