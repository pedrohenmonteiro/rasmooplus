package com.mont.rasmooplus.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {

    private Long id;
    @NotBlank
    private String name;
    
    @Max(value = 12)
    private Long accessMonths;
    private BigDecimal price;
    @NotBlank
    @Size(min = 2, max = 15)
    private String productKey;
}
