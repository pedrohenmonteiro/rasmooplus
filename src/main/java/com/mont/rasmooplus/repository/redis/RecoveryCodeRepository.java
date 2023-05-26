package com.mont.rasmooplus.repository.redis;

import org.springframework.data.repository.CrudRepository;

import com.mont.rasmooplus.model.redis.RecoveryCode;

public interface RecoveryCodeRepository extends CrudRepository<RecoveryCode, String> {
    
}
