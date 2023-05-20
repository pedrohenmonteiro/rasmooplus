package com.mont.rasmooplus.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailIntegrationTest {

    @Autowired
    private MailIntegration mailIntegration;

    
    @Test
    void sendEmailTest(){
        mailIntegration.send("pedro.monteiro@edu.unifil.br", "Olá, Pedro! Bom te ver aqui!", "Olá, como vai?");
    }

    
}
