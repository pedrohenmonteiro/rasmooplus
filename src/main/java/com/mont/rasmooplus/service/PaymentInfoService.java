package com.mont.rasmooplus.service;

import com.mont.rasmooplus.dto.PaymentProcessDto;

public interface PaymentInfoService {
    
    Boolean process(PaymentProcessDto dto);
}
