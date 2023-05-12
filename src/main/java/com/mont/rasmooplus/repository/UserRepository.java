package com.mont.rasmooplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
