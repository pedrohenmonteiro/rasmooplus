package com.mont.rasmooplus.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mont.rasmooplus.dto.wsraspay.UserPaymentInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProcessDto {
    @NotBlank(message = "must be informed")
    private String productKey;
    
    private BigDecimal discount;
    @NotNull(message = "payment data must be informed")
    @JsonProperty("userPaymentInfo")
    private UserPaymentInfoDto userPaymentInfoDto;
    
}
