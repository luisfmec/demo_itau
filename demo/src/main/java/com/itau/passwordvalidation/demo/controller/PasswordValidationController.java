package com.itau.passwordvalidation.demo.controller;

import com.itau.passwordvalidation.demo.usecase.PasswordValidationUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordValidationController {

    @PostMapping(value = "/password-validation")
    private boolean passwordIsValid(@RequestBody String password){
        //calls static method to check whether password is valid
        return PasswordValidationUseCase.passwordValidation(password);
    }

}
