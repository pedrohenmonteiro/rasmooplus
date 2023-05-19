package com.mont.rasmooplus.mapper.wsraspay;

import com.mont.rasmooplus.dto.wsraspay.CreditCardDto;
import com.mont.rasmooplus.dto.wsraspay.UserPaymentInfoDto;

public class CreditCardMapper {
    
    public static CreditCardDto build(UserPaymentInfoDto dto, String documentNumber) {
        return CreditCardDto.builder()
        .documentNumber(documentNumber)
        .cvv(Long.parseLong(dto.getCardSecurityCode()))
        .number(dto.getCardNumber())
        .month(dto.getCardExpirationMonth())
        .year(dto.getCardExpirationYear())
        .installments(dto.getInstallments()) 
        .build();
    }
}
