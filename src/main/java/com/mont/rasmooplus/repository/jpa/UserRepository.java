package com.mont.rasmooplus.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.jpa.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
