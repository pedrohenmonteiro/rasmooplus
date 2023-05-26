package com.mont.rasmooplus.repository.redis;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mont.rasmooplus.model.redis.UserRecoveryCode;

public interface UserRecoveryCodeRepository extends CrudRepository<UserRecoveryCode, String> {
    
    Optional<UserRecoveryCode> findByEmail(String email);
}
