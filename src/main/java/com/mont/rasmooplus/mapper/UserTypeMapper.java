package com.mont.rasmooplus.mapper;

import com.mont.rasmooplus.dto.UserTypeDto;
import com.mont.rasmooplus.model.UserType;

public class UserTypeMapper {
    
    public static UserType fromDtoToEntity(UserTypeDto dto) {
        return UserType.builder()
        .id(dto.getId())
        .name(dto.getName())
        .description(dto.getDescription())
        .build();
    }
}
