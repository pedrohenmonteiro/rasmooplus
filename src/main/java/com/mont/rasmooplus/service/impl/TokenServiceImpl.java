package com.mont.rasmooplus.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.model.UserCredentials;
import com.mont.rasmooplus.service.TokenService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${webservices.rasplus.jwt.expiration}")
    private String expiration;

    @Value("${webservices.rasplus.jwt.secret}")
    private String secret;

    @Override
    public String getToken(Authentication auth) {
        UserCredentials user = (UserCredentials) auth.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("API Rasmoo Plus")
                .setSubject(user.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}