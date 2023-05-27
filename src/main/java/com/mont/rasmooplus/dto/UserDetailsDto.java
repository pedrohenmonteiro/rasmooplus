package com.mont.rasmooplus.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    
    @Email(message ="invalid email")
    private String email;

    @NotBlank(message = "invalid atribute")
    private String password;

    private String recoveryCode;
}
