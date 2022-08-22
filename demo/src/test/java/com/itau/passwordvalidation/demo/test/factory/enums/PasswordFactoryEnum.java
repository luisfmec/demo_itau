package com.itau.passwordvalidation.demo.test.factory.enums;

public enum PasswordFactoryEnum {
    
    VALID_PASSWORD("AbTp9!fok"),
    INVALID_PASSWORD("AbTp9 fok"),
    INVALID_REPEATED_CHARS_PASSWORD("1Ab@qweAt");

    private String password;

    PasswordFactoryEnum(String password){
        this.password = password;
    }

    public String toString(){
        return password;
    }

}
