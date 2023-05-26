package com.mont.rasmooplus.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.model.UserCredentials;
import com.mont.rasmooplus.repository.UserDetailsRepository;
import com.mont.rasmooplus.service.TokenService;


public class AuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private UserDetailsRepository userDetailsRepository;

    public AuthenticationFilter(TokenService tokenService, UserDetailsRepository userDetailsRepository) {
        this.tokenService = tokenService;
        this.userDetailsRepository = userDetailsRepository;
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

    private void authByToken(String token) {
        Long userId = tokenService.getUserId(token);

        UserCredentials user = userDetailsRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));

        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    
        SecurityContextHolder.getContext().setAuthentication(userAuth);
    }


    private String getBearerToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if(Objects.isNull(token) || !token.startsWith("Bearer")) {
            return null;
        }

        return token.substring(7);
    }

 

}
