package com.itau.passwordvalidation.demo.test.integration.controller;

import com.itau.passwordvalidation.demo.test.factory.enums.PasswordFactoryEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PasswordValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.
                        post("http://localhost:8080/password-validation")
                        .content(PasswordFactoryEnum.VALID_PASSWORD.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    void testInvalidPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.
                        post("http://localhost:8080/password-validation")
                        .content(PasswordFactoryEnum.INVALID_PASSWORD.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @Test
    void testInvalidPasswordException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.
                        post("http://localhost:8080/password-validation"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

}


