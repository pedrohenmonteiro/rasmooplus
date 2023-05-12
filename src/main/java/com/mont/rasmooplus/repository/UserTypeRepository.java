package com.mont.rasmooplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long>{
    
}
