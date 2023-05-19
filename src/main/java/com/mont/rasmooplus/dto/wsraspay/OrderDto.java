package com.mont.rasmooplus.dto.wsraspay;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String id;
    private String customerId;
    private BigDecimal discount;
    private String productAcronym;
}

