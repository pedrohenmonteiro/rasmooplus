package com.mont.rasmooplus.integration;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mont.rasmooplus.dto.wsraspay.CreditCardDto;
import com.mont.rasmooplus.dto.wsraspay.CustomerDto;
import com.mont.rasmooplus.dto.wsraspay.OrderDto;
import com.mont.rasmooplus.dto.wsraspay.PaymentDto;

@SpringBootTest
public class WsRaspayIntegrationTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;


    @Test
    void createCustomerWhenDtoOK() {
        CustomerDto dto = new CustomerDto(null, "61275123600", "losd@lari", "Laura", "Satim");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderWhenDtoOK(){
        OrderDto dto = new OrderDto(null,"646785af5fbff1508a95880d", BigDecimal.ZERO,"YEAR22");
        wsRaspayIntegration.createOrder(dto);
    }

    @Test
    void processPaymentWhenDtoOK(){
        CreditCardDto creditCardDto = new CreditCardDto(123L,"02371386030",0L,06L,"1234123412341234",2025L);
        PaymentDto paymentDto = new PaymentDto(creditCardDto,"646785af5fbff1508a95880d","6467a22d5fbff1508a95880f");
        wsRaspayIntegration.processPayment(paymentDto);
    }
    
}
