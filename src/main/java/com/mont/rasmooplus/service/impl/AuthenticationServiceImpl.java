package com.mont.rasmooplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.dto.LoginDto;
import com.mont.rasmooplus.dto.TokenDto;
import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.model.jpa.UserCredentials;
import com.mont.rasmooplus.service.AuthenticationService;
import com.mont.rasmooplus.service.TokenService;
import com.mont.rasmooplus.service.UserDetailsService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

   @Autowired
   private UserDetailsService userDetailsService;

    @Autowired
    private TokenService tokenService;

    @Override
    public TokenDto auth(LoginDto dto) {
        try {
            UserCredentials userCredentials = userDetailsService.loadUserByUsernameAndPass(dto.getUsername(), dto.getPassword());
            String token = tokenService.getToken(userCredentials.getId());
            return TokenDto.builder().token(token).type("Bearer").build();
        } catch (Exception e) {
            throw new BadRequestException("Erro ao formatar token - "+e.getMessage());
        }
    }
}

