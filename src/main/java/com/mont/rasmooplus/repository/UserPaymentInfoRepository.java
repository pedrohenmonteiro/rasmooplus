package com.mont.rasmooplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.UserPaymentInfo;

public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfo, Long>{
    
}
