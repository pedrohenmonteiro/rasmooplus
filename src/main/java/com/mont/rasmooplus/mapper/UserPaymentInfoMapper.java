package com.mont.rasmooplus.mapper;

import com.mont.rasmooplus.dto.wsraspay.UserPaymentInfoDto;
import com.mont.rasmooplus.model.User;
import com.mont.rasmooplus.model.UserPaymentInfo;

public class UserPaymentInfoMapper {
    public static UserPaymentInfo fromDtoToEntity(UserPaymentInfoDto dto, User user) {
        return UserPaymentInfo.builder()
        .id(dto.getId())
        .cardNumber(dto.getCardNumber())
        .cardExpirationMonth(dto.getCardExpirationMonth())
        .cardExpirationYear(dto.getCardExpirationYear())
        .cardSecurityCode(dto.getCardSecurityCode())
        .price(dto.getPrice())
        .dtPayment(dto.getDtPayment())
        .user(user)
        .build();
    }
}
