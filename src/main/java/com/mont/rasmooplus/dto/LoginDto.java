package com.mont.rasmooplus.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
