package com.mont.rasmooplus.service.impl;

import java.util.Objects;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.mont.rasmooplus.dto.UserDto;
import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.mapper.UserMapper;
import com.mont.rasmooplus.model.jpa.User;
import com.mont.rasmooplus.model.jpa.UserType;
import com.mont.rasmooplus.model.redis.UserRecoveryCode;
import com.mont.rasmooplus.repository.jpa.UserRepository;
import com.mont.rasmooplus.repository.jpa.UserTypeRepository;
import com.mont.rasmooplus.repository.redis.UserRecoveryCodeRepository;
import com.mont.rasmooplus.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserTypeRepository userTypeRepository;

    private final UserRecoveryCodeRepository recoveryCodeRepository;

    UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository, UserRecoveryCodeRepository recoveryCodeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.recoveryCodeRepository = recoveryCodeRepository;
    }

    @Override
    public User create(UserDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("id deve ser nulo");
        }

        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());

        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException("userTypeId não encontrado");
        }

        UserType userType = userTypeOpt.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);
        return userRepository.save(user);
    }

   
}
