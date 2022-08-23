package com.itau.passwordvalidation.demo.usecase;

import java.util.regex.Pattern;

public class PasswordValidationUseCase {

    //0-9 - contains at least one number
    //a-z - contains at least one lower case
    //A-Z - contains at least one upper case
    //!@#$%^&*()-+ - special characters
    //S+$ - white spaces
    //9 - at least nine positions
    private static final String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?=\\S+$).{9,}$";

    public static boolean passwordValidation(String password){
        //Check if string matches pattern, if not immediately returns false
        if(Pattern.matches(pattern,password)){
            return notRepeatedChar(password); //pattern being matched, immediately returns status of method that checks for duplicated chars in string
        } return false; //string did not match pattern
    }

    private static boolean notRepeatedChar(String password){
        for(int i = 0;i<password.length();i++){ //starts from first char to evaluate. Swipes throughout charset for evaluation(checks all positions if none is duplicated)
            for(int j=i+1;j<password.length();j++){ //starts from second char, to evaluate with first and so on. Is always i+1 and swipes throughout charset. Immediately returns false if match
                if(password.charAt(i) == password.charAt(j))
                    return false; //char is present and so we have to return false
            }
        }
        return true; //no chars are repeated so we return true
    }

}
