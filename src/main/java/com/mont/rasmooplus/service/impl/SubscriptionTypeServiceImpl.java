package com.mont.rasmooplus.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.dto.SubscriptionTypeDto;
import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.mapper.SubscriptionTypeMapper;
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
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Resource Not Found"));
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        if(Objects.nonNull(dto.getId())) throw new BadRequestException("Id must be null");
        return repository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }


    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        var entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Resource Not Found"));
        dto.setId(entity.getId());
        return repository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }




}
