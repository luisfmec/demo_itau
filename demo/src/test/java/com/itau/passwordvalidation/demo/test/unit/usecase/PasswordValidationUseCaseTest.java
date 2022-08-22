package com.itau.passwordvalidation.demo.test.unit.usecase;

import com.itau.passwordvalidation.demo.test.factory.enums.PasswordFactoryEnum;
import com.itau.passwordvalidation.demo.usecase.PasswordValidationUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationUseCaseTest {

    @Test
    void validPasswordTest(){
        Assertions.assertTrue(PasswordValidationUseCase.passwordValidation(PasswordFactoryEnum.VALID_PASSWORD.toString()));
    }

    @Test
    void invalidPasswordTest(){
        Assertions.assertFalse(PasswordValidationUseCase.passwordValidation(PasswordFactoryEnum.INVALID_PASSWORD.toString()));
    }

    @Test
    void invalidPasswordWithRepeatedChar(){
        Assertions.assertFalse(PasswordValidationUseCase.passwordValidation(PasswordFactoryEnum.INVALID_REPEATED_CHARS_PASSWORD.toString()));
    }

}
