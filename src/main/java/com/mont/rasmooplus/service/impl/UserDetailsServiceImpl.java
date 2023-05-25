package com.mont.rasmooplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mont.rasmooplus.exception.NotFoundException;
import com.mont.rasmooplus.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userDetailsRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found"));
        return user;
    }
    
}
