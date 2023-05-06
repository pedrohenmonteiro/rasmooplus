package com.mont.rasmooplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.model.SubscriptionType;
import com.mont.rasmooplus.repository.SubscriptionTypeRepository;
import com.mont.rasmooplus.service.SubscriptionTypeService;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {
    
    @Autowired
    private SubscriptionTypeRepository repository;

    @Override
    public List<SubscriptionType> findAll() {
        return repository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
