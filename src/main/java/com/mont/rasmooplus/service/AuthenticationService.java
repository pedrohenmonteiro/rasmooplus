package com.mont.rasmooplus.service;

import com.mont.rasmooplus.dto.LoginDto;
import com.mont.rasmooplus.dto.TokenDto;

public interface AuthenticationService {

    TokenDto auth(LoginDto dto);

}