package com.mont.rasmooplus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mont.rasmooplus.dto.LoginDto;
import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.service.TokenService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken userPassAuth = new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword());

       try {
       Authentication auth = authenticationManager.authenticate(userPassAuth);
        String token = tokenService.getToken(auth);
        return ResponseEntity.ok().body(token);
       } catch (Exception e) {
        throw new BadRequestException("error formatting token " + e.getMessage());
       }
    }
}
