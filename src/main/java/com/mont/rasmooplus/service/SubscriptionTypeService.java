package com.mont.rasmooplus.service;

import java.util.List;

import com.mont.rasmooplus.model.SubscriptionType;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();
    
    SubscriptionType findById(Long id);

    SubscriptionType update(Long id, SubscriptionType obj);

    void delete(Long id);
    
}
