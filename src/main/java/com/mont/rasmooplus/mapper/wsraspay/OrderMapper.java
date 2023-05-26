package com.mont.rasmooplus.mapper.wsraspay;

import com.mont.rasmooplus.dto.PaymentProcessDto;
import com.mont.rasmooplus.dto.wsraspay.OrderDto;

public class OrderMapper {

    public static OrderDto build(String customerId, PaymentProcessDto paymentProcessDto) {
        return OrderDto.builder()
                .customerId(customerId)
                .productAcronym(paymentProcessDto.getProductKey())
                .discount(paymentProcessDto.getDiscount())
                .build();
    }
}
