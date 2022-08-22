package com.itau.passwordvalidation.demo.controller;

import com.itau.passwordvalidation.demo.usecase.PasswordValidationUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordValidationController {

    @PostMapping(value = "/password-validation")
    private boolean isValid(@RequestBody String password){
        return PasswordValidationUseCase.passwordValidation(password);
    }

}
