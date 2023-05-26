package com.mont.rasmooplus.mapper;

import com.mont.rasmooplus.dto.UserDto;
import com.mont.rasmooplus.model.jpa.SubscriptionType;
import com.mont.rasmooplus.model.jpa.User;
import com.mont.rasmooplus.model.jpa.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }
}
