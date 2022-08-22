package com.itau.passwordvalidation.demo.usecase;

import java.util.regex.Pattern;

public class PasswordValidationUseCase {

    private static final String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{9,}$";

    public static boolean passwordValidation(String password){
        if(Pattern.matches(pattern,password)){
            return findSameWithin(password);
        } return false;
    }

    private static boolean findSameWithin(String password){
        for(int i = 0;i<password.length();i++){
            for(int j=i+1;j<password.length();j++){
                if(password.charAt(i) == password.charAt(j))
                    return false;
            }
        }
        return true;
    }

}
