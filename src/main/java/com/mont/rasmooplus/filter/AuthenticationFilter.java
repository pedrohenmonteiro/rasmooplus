package com.mont.rasmooplus.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mont.rasmooplus.service.TokenService;


public class AuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    public AuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        String token = getBearerToken(request);

        if(tokenService.isValid(token)) {
            authByToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private String getBearerToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if(Objects.isNull(token) || !token.startsWith("Bearer")) {
            return null;
        }

        return token.substring(7);
    }

 

}
