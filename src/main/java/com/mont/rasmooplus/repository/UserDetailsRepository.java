package com.mont.rasmooplus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.UserCredentials;

public interface UserDetailsRepository extends JpaRepository<UserCredentials, Long>{
    
    Optional<UserCredentials> findByUsername(String username);
}
