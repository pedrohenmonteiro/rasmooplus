package com.mont.rasmooplus.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.dto.UserDto;
import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.mapper.UserMapper;
import com.mont.rasmooplus.model.User;
import com.mont.rasmooplus.repository.UserRepository;
import com.mont.rasmooplus.repository.UserTypeRepository;
import com.mont.rasmooplus.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;


    @Override
    public User create(UserDto dto) {
       if(Objects.nonNull(dto.getId())) throw new BadRequestException("Id must be null");
       var userType = userTypeRepository.findById(dto.getUserTypeId()).orElseThrow(() -> new NotFoundException("Resource not found"));
       var user = UserMapper.fromDtoToEntity(dto, userType, null);

       return userRepository.save(user);

    }
    
}
