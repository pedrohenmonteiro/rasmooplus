package com.mont.rasmooplus.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mont.rasmooplus.dto.wsraspay.CustomerDto;

@SpringBootTest
public class WsRaspayIntegrationTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;


    @Test
    void createCustomerWhenDtoOK() {
        CustomerDto dto = new CustomerDto(null, "59224332293", "teste@teste", "Pedro", "Monteiro");
        wsRaspayIntegration.createCustomer(dto);
    }
    
}
