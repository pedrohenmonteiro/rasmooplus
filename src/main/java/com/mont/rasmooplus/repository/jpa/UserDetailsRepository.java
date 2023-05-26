package com.mont.rasmooplus.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.jpa.UserCredentials;

public interface UserDetailsRepository extends JpaRepository<UserCredentials, Long>{
    
    Optional<UserCredentials> findByUsername(String username);
}
