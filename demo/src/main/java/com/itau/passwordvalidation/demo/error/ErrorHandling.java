package com.itau.passwordvalidation.demo.error;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandling {
    //handles HttpMessageNotReadableException for when null string is the content
    //returns false, as requested by issue
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<Boolean> handleInputException(){return ResponseEntity.ok().body(Boolean.FALSE);}
}
