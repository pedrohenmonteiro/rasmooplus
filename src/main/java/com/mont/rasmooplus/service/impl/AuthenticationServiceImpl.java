package com.mont.rasmooplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.dto.LoginDto;
import com.mont.rasmooplus.dto.TokenDto;
import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.service.AuthenticationService;
import com.mont.rasmooplus.service.TokenService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public TokenDto auth(LoginDto dto) {
        try {
            UsernamePasswordAuthenticationToken userPassAuth = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
       Authentication auth = authenticationManager.authenticate(userPassAuth);
        String token = tokenService.getToken(auth);

        return TokenDto.builder().token(token).type("Bearer").build();
        } catch (Exception e) {
            throw new BadRequestException("Error generating token - " + e.getMessage());
        }
    }
    
}
