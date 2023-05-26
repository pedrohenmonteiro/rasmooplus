package com.mont.rasmooplus.mapper.wsraspay;

import com.mont.rasmooplus.dto.wsraspay.CreditCardDto;
import com.mont.rasmooplus.dto.wsraspay.PaymentDto;

public class PaymentMapper {

    public static PaymentDto build(String customerId, String orderId, CreditCardDto dto) {

        return PaymentDto.builder()
                .customerId(customerId)
                .orderId(orderId)
                .creditCard(dto)
                .build();

    }

}
