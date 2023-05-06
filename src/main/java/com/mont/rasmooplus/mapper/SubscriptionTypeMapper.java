package com.mont.rasmooplus.mapper;

import com.mont.rasmooplus.dto.SubscriptionTypeDto;
import com.mont.rasmooplus.model.SubscriptionType;

public class SubscriptionTypeMapper {
    
    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
        return SubscriptionType.builder()
        .id(dto.getId())
        .name(dto.getName())
        .accessMonths(dto.getAccessMonths())
        .price(dto.getPrice())
        .productKey(dto.getProductKey())
        .build();
    }
}
