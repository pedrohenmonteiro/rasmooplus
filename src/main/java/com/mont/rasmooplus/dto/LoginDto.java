package com.mont.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    
    private String userName;
    private String password;
}
