package com.mont.rasmooplus.service;

import java.util.List;

import com.mont.rasmooplus.dto.SubscriptionTypeDto;
import com.mont.rasmooplus.model.jpa.SubscriptionType;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();
    
    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionTypeDto dto);

    SubscriptionType update(Long id, SubscriptionTypeDto dto);

    void delete(Long id);
    
}
