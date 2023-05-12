package com.mont.rasmooplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.model.UserType;
import com.mont.rasmooplus.repository.UserTypeRepository;
import com.mont.rasmooplus.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService{

    @Autowired
    private UserTypeRepository repository;

    @Override
    public List<UserType> findAll() {
        return repository.findAll();
    }
    

}
