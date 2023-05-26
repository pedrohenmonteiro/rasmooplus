package com.mont.rasmooplus.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mont.rasmooplus.model.UserType;
import com.mont.rasmooplus.repository.UserTypeRepository;
import com.mont.rasmooplus.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }
}

