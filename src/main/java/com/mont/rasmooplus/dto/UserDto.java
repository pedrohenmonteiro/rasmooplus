package com.mont.rasmooplus.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.usertype.UserType;
import org.hibernate.validator.constraints.br.CPF;

import com.mont.rasmooplus.model.SubscriptionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @Size(min = 11)
    private String phone;
    @CPF
    private String cpf;

    private LocalDate dtSubscription = LocalDate.now();

    private LocalDate dtExpiration = LocalDate.now();;
    
    @NotNull
    private Long userTypeId;

    private Long subscriptionTypeId;
}

