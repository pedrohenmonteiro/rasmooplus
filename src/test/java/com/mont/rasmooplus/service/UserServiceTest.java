package com.mont.rasmooplus.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserDetailsService userService;
    
    @Test
    void contextLoads() {
        userService.sendRecoveryCode("4536c8a0ad@fireboxmail.lol");
    }
}
