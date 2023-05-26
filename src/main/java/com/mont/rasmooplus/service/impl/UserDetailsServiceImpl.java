package com.mont.rasmooplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.exception.BadRequestException;
import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.model.UserCredentials;
import com.mont.rasmooplus.repository.UserDetailsRepository;
import com.mont.rasmooplus.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserCredentials loadUserByUsernameAndPass(String username, String pass) {
         UserCredentials userCredentials = userDetailsRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found"));
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         if(encoder.matches(pass, userCredentials.getPassword())) {
            return userCredentials;
         }
         throw new BadRequestException("Invalid user or password");
    }

  

    
}
