package com.mont.rasmooplus.dto.wsraspay;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentInfoDto {
  
    private Long id;
    @Size(min = 16, max = 16, message = "must contain 16 characters")
    private String cardNumber;
    @Min(value = 1)
    @Max(value = 12)
    private Long cardExpirationMonth;
    private Long cardExpirationYear;

    @Size(min = 3, max = 3, message = "must contain 3 characters")
    private String cardSecurityCode;
    private BigDecimal price;

    private Long installments;
    private LocalDate dtPayment = LocalDate.now();

    @NotNull(message = "must be informed")
    private Long userId;

}
