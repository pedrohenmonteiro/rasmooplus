package com.mont.rasmooplus.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mont.rasmooplus.model.jpa.UserPaymentInfo;

public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfo, Long>{
    
}
