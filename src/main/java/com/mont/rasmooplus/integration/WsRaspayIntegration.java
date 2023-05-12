package com.mont.rasmooplus.integration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mont.rasmooplus.dto.wsraspay.CustomerDto;
import com.mont.rasmooplus.dto.wsraspay.OrderDto;
import com.mont.rasmooplus.dto.wsraspay.PaymentDto;


@Component
public class WsRaspayIntegration {

    private RestTemplate restTemplate;

    public WsRaspayIntegration() {
        restTemplate = new RestTemplate();
    }

    
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpHeaders headers = getHttpHeaders();
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto, headers);
            ResponseEntity<CustomerDto> response = 
                restTemplate.exchange("https://ws-raspay.herokuapp.com/ws-raspay/v1/customer", HttpMethod.POST, request, CustomerDto.class);
                
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }


    
    public OrderDto createOrder(OrderDto dto) {
        return null;
    }

    public Boolean processPayment(PaymentDto dto) {
        return null;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = new String (Base64.encodeBase64(credential.getBytes()));
        headers.add("Authorization", "Basic "+base64);
        return headers;
    }

}
